package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.ShelterDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class ShelterDAO {

	public static List<ShelterDTO> getShelter(String sido, String sigungu) {
		List<ShelterDTO> dto = new ArrayList<>();

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.SELECT_SHELTER);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if(sido.equals(rs.getString("sido")) && sigungu.equals(rs.getString("sigungu"))) {
					dto.add(new ShelterDTO(
							rs.getString("sido"), 
							rs.getString("sigungu"),
							rs.getString("careNm"),
							rs.getString("careTel"),
							rs.getString("careAddr")
							));
				} else if (sido.equals(rs.getString("sido")) && sigungu.equals("전체")) {
					dto.add(new ShelterDTO(
							rs.getString("sido"), 
							rs.getString("sigungu"),
							rs.getString("careNm"),
							rs.getString("careTel"),
							rs.getString("careAddr")
							));
				} else if (sido.equals("전국")) {
					dto.add(new ShelterDTO(
							rs.getString("sido"), 
							rs.getString("sigungu"),
							rs.getString("careNm"),
							rs.getString("careTel"),
							rs.getString("careAddr")
							));
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
}
