package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ver1.DTO.LoginDTO;
import ver1.jdbc.DBConnectionManager;

public class LoginDAO {

	public static LoginDTO selectLogin(String userName) {
		LoginDTO dto = null;
		String query = " select userName, userPassWord from user where userName = ? ";
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new LoginDTO(rs.getString("userName"), rs.getString("userPassWord"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public static String selectName() {
		String str = null;
		
		
		
		return str;
	}
	
}
