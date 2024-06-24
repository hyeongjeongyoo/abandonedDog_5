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
		String query = " select userName, name, userPassWord, userBirth, authority, userTel, userDepartmentNo, userDepartmentName from user where userName = ? ";
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new LoginDTO(rs.getString("name"),
								rs.getString("userName"),
								rs.getString("userPassWord"),
								rs.getString("userBirth"),
								rs.getString("authority"),
								rs.getString("userTel"),
								rs.getString("userDepartmentNo"),
								rs.getString("userDepartmentName")
								);
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
