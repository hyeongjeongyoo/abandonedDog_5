package ver1.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class AnimalParsing {

	public static void main(String[] args) throws IOException {

		URL url = new URL(ParsingUrl.KIND_CAT);

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

		JsonAnimalDTO dogDTO = gson.fromJson(sb.toString(), JsonAnimalDTO.class);

		try (Connection connect = DBConnectionManager.getConnection()) {

			int count = 0;
			for (JsonAnimalDTO.item item : dogDTO.response.body.items.item) {
				PreparedStatement pstmt = connect.prepareStatement(Define.KIND_PARSING_DATA);
				pstmt.setString(1, item.kindCd);
				pstmt.setString(2, item.knm);
				pstmt.executeUpdate();
				count++;
			}
			System.out.println("저장된 행 : " + count);
		} catch (Exception e) {
		}

	}
}


