package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.AdoptDTO;
import ver1.DTO.FreeBoardDTO;
import ver1.DTO.InterestDTO;
import ver1.DTO.MissingBoardDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class MyPageDAO {

	public static AdoptDTO selectapplyForm(int value) {

		AdoptDTO dto = null;

		try (Connection conn = DBConnectionManager.getConnection()) {
			// todo define 재정의
			PreparedStatement pstmt = conn.prepareStatement(Define.ALL_VIEW_ANIMAL_DETAILS);
			pstmt.setInt(1, value);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				dto = new AdoptDTO(rs.getString("name"), rs.getString("address"), rs.getString("number"),
						rs.getString("email"), rs.getString("age"), rs.getString("sex"), rs.getString("job"),
						rs.getString("maritalStatus"), rs.getString("visitDate"), rs.getString("animalId"),
						rs.getString("raisedPet"), rs.getString("sizeFamily"), rs.getString("permission"),
						rs.getInt("careId"));
			}

		} catch (Exception e) {
		}
		return dto;
	}

	public static void insertApplyAdopt(AdoptDTO adoptDTO) {

		AdoptDTO dto = adoptDTO;
		try (Connection conn = DBConnectionManager.getConnection()) {
			// todo define 재정의
			PreparedStatement pstmt = conn.prepareStatement(Define.INSERT_APPLY_ADOPT);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddress());
			pstmt.setString(3, dto.getNumber());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getAge());
			pstmt.setString(6, dto.getSex());
			pstmt.setString(7, dto.getJob());
			pstmt.setString(8, dto.getMaritalStatus());
			pstmt.setString(9, dto.getVisitDate());
			pstmt.setString(10, dto.getAnimalId());
			pstmt.setString(11, dto.getRaisedPet());
			pstmt.setString(12, dto.getSizeFamily());
			pstmt.setInt(13, dto.getCareId());
			pstmt.executeUpdate();

		} catch (Exception e) {
		}
	}
	
	public static int searchShelter(String careNm) {
		String query = " select careId from shelter where careNm = ? ";
		int shelterName = 0;
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, careNm);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				shelterName = rs.getInt("careId");
			}
			
		} catch (SQLException e) {
		}
		
		
		return shelterName;
	}
	
	public static MissingBoardDTO interestAnimal(int animalId) {
		MissingBoardDTO boardDTO = null;
		String query = " select * from animal_details where id = ? ";
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, animalId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				boardDTO = new MissingBoardDTO(
										rs.getInt("id"), 
										rs.getString("kindCd"), 
										rs.getString("colorCd"), 
										rs.getString("age"), 
										rs.getString("weight"), 
										rs.getString("processState"), 
										rs.getString("sexCd"), 
										rs.getString("neuterYn"), 
										rs.getString("specialMark"), 
										rs.getInt("emp_no"), 
										rs.getInt("careId"));
			}
			
		} catch (SQLException e) {
		}
		
		return boardDTO;
	}
	
	public static void insertInterestAnimal(int animalId, String userName) {
		MissingBoardDTO boardDTO = interestAnimal(animalId);
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(Define.INSERT_MY_INTEREST);
			pstmt.setInt(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getKindCd());
			pstmt.setString(3, userName);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
		}
	}
	
	public static List<InterestDTO> addInterestAnimal(String userName) {
		List<InterestDTO> dtos = new ArrayList<>();
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(Define.MY_INTEREST_BOARD);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dtos.add(new InterestDTO(rs.getInt("id"), rs.getString("kindCd"), rs.getString("addDate"), rs.getString("userName")));
			}
		} catch (SQLException e) {
		}
		
		return dtos;
	}
	
	public static List<FreeBoardDTO> addMyWrite(String userName) {
		List<FreeBoardDTO> dtos = new ArrayList<>();
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(Define.MY_WRITER_BOARD);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dtos.add(new FreeBoardDTO(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("username"),
						rs.getString("content"),
						rs.getString("create_date")));
			}
		} catch (SQLException e) {
		}
		
		return dtos;
	}

	public static void updateInfo(String query, String value, String userName) {
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setString(2, userName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void deleteInterest(int id, String userName) {
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(Define.DELETE_INTEREST);
			pstmt.setInt(1, id);
			pstmt.setString(2, userName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
