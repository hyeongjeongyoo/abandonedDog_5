package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.FreeBoardDTO;
import ver1.jdbc.DBConnectionManager;

public class FreeBoardDAO {

	public static void addFreeBoardDAO(String title, String username, String content) {
		String query = " insert into freeboarddb(title, username, content, create_date) values (?, ?, ?, CURRENT_DATE()) ";
		
		try(Connection conn = DBConnectionManager.getConnection();) {

			PreparedStatement pstmt = conn.prepareStatement(query);
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
		String query = " select * from freeboarddb order by id desc ";
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new FreeBoardDTO(
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
	
	public static FreeBoardDTO getBoardDto(String username) {
		FreeBoardDTO dto = null;
		String query = " select * from freeboarddb where username = ? ";
		
		try(Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new FreeBoardDTO(
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
	
	public static List<FreeBoardDTO> getBoardDtos(String username) {
		List<FreeBoardDTO> dtos = new ArrayList<>();
		FreeBoardDTO dto = null;
		String query = " select * from freeboarddb where username = ? ";
		
		try(Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dto = new FreeBoardDTO(
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
