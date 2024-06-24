package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.ReviewBoardDTO;
import ver1.jdbc.DBConnectionManager;

public class ReviewBoardDAO {

	public static void addReviewBoardDAO(String title, String username, String content) {
		String query = "INSERT INTO reviewboarddb(title, username, content, create_date) VALUES (?, ?, ?, CURRENT_DATE())";
		
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, username);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<ReviewBoardDTO> getReviewBoard() {
		List<ReviewBoardDTO> list = new ArrayList<>();
		String query = "SELECT * FROM reviewboarddb ORDER BY id DESC";
		
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ReviewBoardDTO(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("username"),
					rs.getString("content"),
					rs.getString("create_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static ReviewBoardDTO getBoardDto(String username) {
		ReviewBoardDTO dto = null;
		String query = "SELECT * FROM reviewboarddb WHERE username = ?";
		
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ReviewBoardDTO(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("username"),
					rs.getString("content"),
					rs.getString("create_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public static List<ReviewBoardDTO> getBoardDtos(String username) {
		List<ReviewBoardDTO> dtos = new ArrayList<>();
		String query = "SELECT * FROM reviewboarddb WHERE username = ?";
		
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewBoardDTO dto = new ReviewBoardDTO(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("username"),
					rs.getString("content"),
					rs.getString("create_date"));
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;
	}
}