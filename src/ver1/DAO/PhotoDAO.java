package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ver1.DTO.PhotoDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class PhotoDAO {

	public static String randomPhoto() {
		PhotoDTO dto = null;
		String tempPhoto = "";
		
		try(Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.MAIN_PHOTO);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new PhotoDTO(rs.getString("popfile"));
			}

			tempPhoto = dto.getPopfile();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tempPhoto.replaceFirst("http", "https").trim();
	}
	
}
