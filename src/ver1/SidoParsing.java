package ver1;

import java.net.HttpURLConnection;
import java.net.URL;

public class SidoParsing {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// end of main
	
}// end of class
