package ver1.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lombok.Data;
import ver1.jdbc.DBConnectionManager;

public class Shelter {
	
	public static String shelter(String uprCd, String orgCd) {
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter"
				+ "?upr_cd=" + uprCd
				+ "&org_cd=" + orgCd
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
			
			while(itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();
				list.add(String.format(entry.getKey())+ "," + String.format(entry.getValue()));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}// end of class
