package ver1.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class ShelterParsing {

	public static void main(String[] args) throws IOException {

		List<String> list = addShelter();

		for (int i = 0; i < list.size(); i++) {

			StringTokenizer st = new StringTokenizer(list.get(i), ",");
			String orgCd = st.nextToken();
			String uprCd = st.nextToken();
			URL url = new URL(shelter(uprCd, orgCd));

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

			JsonShelterDTO dto = gson.fromJson(sb.toString(), JsonShelterDTO.class);
			try (Connection connect = DBConnectionManager.getConnection()) {

				int count = 0;
				for (JsonShelterDTO.item item : dto.response.body.items.item) {
					PreparedStatement pstmt = connect.prepareStatement(Define.INSERT_SHELTER);
					pstmt.setString(1, orgCd);
					pstmt.setString(2, item.careRegNo);
					pstmt.setString(3, item.careNm);
					pstmt.executeUpdate();
					count++;
				}
				System.out.println("저장된 행 : " + count);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}

			rd.close();
			conn.disconnect();
		}

	}

	public static String shelter(String uprCd, String orgCd) {
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter" + "?upr_cd=" + uprCd + "&org_cd="
				+ orgCd
				+ "&serviceKey=palsG47GgfoxfBI5IvepO%2Bs%2BzSWEnnxl74qGa%2FkxbmgoHz4R%2BNYSYXYxeaPeMmUgYDU1V%2BevDZ3g6IoveoEGHQ%3D%3D"
				+ "&_type=json";

		return url;
	}

	public static List<String> addShelter() {

		List<String> list = new ArrayList<>();

		Map<String, String> sigungu = new HashMap<>();
		try {
			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(" SELECT * FROM sigungu ");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				sigungu.put(rs.getString("orgCd"), rs.getString("uprCd"));
			}

			Iterator<Map.Entry<String, String>> itr = sigungu.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();
				list.add(String.format(entry.getKey()) + "," + String.format(entry.getValue()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

}
