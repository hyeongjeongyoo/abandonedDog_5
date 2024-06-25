package ver1.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class AbandonmentParsing {

	public static void main(String[] args) throws IOException{
		for(int i = 1; i < 339; i++) {
			URL url = new URL(ParsingUrl.AbandonmentPublic(20210101, 20240618, i));
	
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
	
			System.out.println("Response code: " + conn.getResponseCode());
	
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
	
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
	
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
			JsonAbandonmentDTO dto = gson.fromJson(sb.toString(), JsonAbandonmentDTO.class);
			try (Connection connect = DBConnectionManager.getConnection()) {
	
				int count = 0;
				for (JsonAbandonmentDTO.item item : dto.response.body.items.item) {
					PreparedStatement pstmt = connect.prepareStatement(Define.DETAILS_PARSING_DATA);
					pstmt.setString(1, item.desertionNo);
					pstmt.setString(2, item.filename);
					pstmt.setString(3, item.happenDt);
					pstmt.setString(4, item.happenPlace);
					pstmt.setString(5, item.kindCd);
					pstmt.setString(6, item.colorCd);
					pstmt.setString(7, item.age);
					pstmt.setString(8, item.weight);
					pstmt.setString(9, item.noticeNo);
					pstmt.setString(10, item.noticeSdt);
					pstmt.setString(11, item.noticeEdt);
					pstmt.setString(12, item.popfile);
					pstmt.setString(13, item.processState);
					pstmt.setString(14, item.sexCd);
					pstmt.setString(15, item.neuterYn);
					pstmt.setString(16, item.specialMark);
					pstmt.setString(17, item.careNm);
					pstmt.setString(18, item.careTel);
					pstmt.setString(19, item.careAddr);
					pstmt.setString(20, item.orgNm);
					pstmt.setString(21, item.chargeNm);
					pstmt.setString(22, item.officetel);
					pstmt.executeUpdate();
					count++;
				}
				System.out.println("저장된 행 : " + count);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
			rd.close();
	        conn.disconnect();
			
			}
	}
	
}
