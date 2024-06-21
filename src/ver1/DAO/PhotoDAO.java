package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ver1.DTO.PhotoDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class PhotoDAO {

	public static String randomPhoto() {
		PhotoDTO dto = null;
		String tempPhoto = "";

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.MAIN_PHOTO);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new PhotoDTO(rs.getString("popfile"));
			}

			tempPhoto = dto.getPopfile();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tempPhoto.replaceFirst("http", "https").trim();
	}

	public static PhotoDTO searchPhoto(int value) {

		PhotoDTO dto = null;

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.SEARCH_ABANDON);
			pstmt.setInt(1, value);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new PhotoDTO(rs.getString("careNm"), rs.getInt("id"), rs.getString("kindCd"),
						rs.getString("colorCd"), rs.getString("age"), rs.getString("weight"), rs.getString("sexCd"),
						rs.getString("neuterYn"), rs.getString("specialMark"), rs.getString("popfile"));
			}

		} catch (Exception e) {
		}
		if(dto == null) {
			JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "조회 실패", JOptionPane.ERROR_MESSAGE);
		}
		return dto;

	}
}
