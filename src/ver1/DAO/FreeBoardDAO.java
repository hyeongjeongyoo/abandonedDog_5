package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.FreeBoardDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class FreeBoardDAO {

	public static void addFreeBoardDAO(String title, String username, String content) {

		try (Connection conn = DBConnectionManager.getConnection();) {

			PreparedStatement pstmt = conn.prepareStatement(Define.INSERT_FREE_BOARD);
			pstmt.setString(1, title);
			pstmt.setString(2, username);
			pstmt.setString(3, content);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<FreeBoardDTO> getFreeBoard() {
		List<FreeBoardDTO> list = new ArrayList<>();
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.SELECT_FREE_BOARD);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new FreeBoardDTO(rs.getInt("id"), rs.getString("title"), rs.getString("username"),
						rs.getString("content"), rs.getString("create_date")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static FreeBoardDTO getBoardDto(String username) {
		FreeBoardDTO dto = null;

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.UPDATE_MY_WRITE);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new FreeBoardDTO(rs.getInt("id"), rs.getString("title"), rs.getString("username"),
						rs.getString("content"), rs.getString("create_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public static List<FreeBoardDTO> getBoardDtos(String username) {
		List<FreeBoardDTO> dtos = new ArrayList<>();
		FreeBoardDTO dto = null;

		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.UPDATE_MY_WRITE);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new FreeBoardDTO(rs.getInt("id"), rs.getString("title"), rs.getString("username"),
						rs.getString("content"), rs.getString("create_date"));
				dtos.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dtos;
	}

}
