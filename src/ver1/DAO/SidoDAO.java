package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ver1.DTO.SidoDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class SidoDAO {

	public static Vector<String> getSido() {
		Vector<String> dto = new Vector<>();

		dto.add("전국");
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.SELECT_SIDO);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SidoDTO sido = new SidoDTO(rs.getString("orgCd"), rs.getString("orgdownNm"));
				dto.add(sido.getOrgdownNm());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

}
