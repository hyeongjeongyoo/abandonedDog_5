package ver1.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiParsing {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL(ParsingUrl.KIND_DOG);
		
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
		
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
	}

	
	
}
