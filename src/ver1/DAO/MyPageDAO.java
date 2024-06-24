package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

import lombok.Builder.Default;
import ver1.DTO.MyPageDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class MyPageDAO {

	public static MyPageDTO applyForm(int value) {

		MyPageDTO dto = null;

		try (Connection conn = DBConnectionManager.getConnection()) {
			// todo define 재정의
			PreparedStatement pstmt = conn.prepareStatement(Define.ALL_VIEW_ANIMAL_DETAILS);
			pstmt.setInt(1, value);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				
				dto = new MyPageDTO(rs.getString("name"),
						rs.getString("address"),
						rs.getString("number"),
						rs.getString("email"),
						rs.getString("age"),
						rs.getString("sex"),
						rs.getString("job"),
						rs.getString("visitDate"),
						rs.getString("visitDate"),
						rs.getString("id"),
						rs.getString("raisedPet"),
						rs.getString("sizeFamily")
						);
			}
		

			}catch(	Exception e){
	}
		if(dto == null) {
			
		}
		return dto;
}

}
