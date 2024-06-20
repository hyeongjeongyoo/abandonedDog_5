package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.MissingBoardDTO;
import ver1.jdbc.DBConnectionManager;

public class MissingBoardDAO {

	public static List<List<MissingBoardDTO>> getMissingDTOList(String query) {
	    List<List<MissingBoardDTO>> dtos = new ArrayList<>();
	    List<MissingBoardDTO> addDto = getMissingDTO(query);
	    
	    int batchSize = 30;
	    for (int i = 0; i < addDto.size(); i += batchSize) {
	        List<MissingBoardDTO> batch = new ArrayList<>();
	        for (int j = i; j < i + batchSize && j < addDto.size(); j++) {
	            batch.add(addDto.get(j));
	        }
	        dtos.add(batch);
	    }
	    
	    return dtos;
	}
	
	public static List<MissingBoardDTO> getMissingDTO(String query) {
		List<MissingBoardDTO> dto = new ArrayList<>();
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.add(new MissingBoardDTO(
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
										rs.getInt("careId")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public static List<List<MissingBoardDTO>> getJoinMissingDTOList(String query, String value) {
	    List<List<MissingBoardDTO>> dtos = new ArrayList<>();
	    List<MissingBoardDTO> addDto = getJoinMissingDTO(query, "%" + value + "%");
	    
	    int batchSize = 30;
	    for (int i = 0; i < addDto.size(); i += batchSize) {
	        List<MissingBoardDTO> batch = new ArrayList<>();
	        for (int j = i; j < i + batchSize && j < addDto.size(); j++) {
	            batch.add(addDto.get(j));
	        }
	        dtos.add(batch);
	    }
	    
	    return dtos;
	}
	
	public static List<MissingBoardDTO> getJoinMissingDTO(String query, String value) {
		List<MissingBoardDTO> dto = new ArrayList<>();
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, value);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.add(new MissingBoardDTO(
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
										rs.getInt("careId")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public static List<List<MissingBoardDTO>> getJoinMissingDTOList(String query, int value) {
	    List<List<MissingBoardDTO>> dtos = new ArrayList<>();
	    List<MissingBoardDTO> addDto = getJoinMissingDTO(query, "%" + value + "%");
	    
	    int batchSize = 30;
	    for (int i = 0; i < addDto.size(); i += batchSize) {
	        List<MissingBoardDTO> batch = new ArrayList<>();
	        for (int j = i; j < i + batchSize && j < addDto.size(); j++) {
	            batch.add(addDto.get(j));
	        }
	        dtos.add(batch);
	    }
	    
	    return dtos;
	}
	
	public static List<MissingBoardDTO> getJoinMissingDTO(String query, int value) {
		List<MissingBoardDTO> dto = new ArrayList<>();
		
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, value);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.add(new MissingBoardDTO(
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
										rs.getInt("careId")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
