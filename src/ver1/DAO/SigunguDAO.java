package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class SigunguDAO {

	public static Vector<String> getSigungu(String sido) {
		Vector<String> dto = new Vector<>();
		dto.add("전체");

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.SELECT_SIGUNGU);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (sido.equals(rs.getString("sido"))) {
					dto.add(rs.getString("sigungu"));
				} else if (sido.equals("전국")) {
					dto.add(rs.getString("sigungu"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
}
