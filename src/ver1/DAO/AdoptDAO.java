package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.AdoptDTO;
import ver1.DTO.ApplyDTO;
import ver1.jdbc.DBConnectionManager;
import ver1.jdbc.Define;

public class AdoptDAO {

	public static void insertApplyAdopt(AdoptDTO adoptDTO) {
		AdoptDTO dto = adoptDTO;
		try (Connection conn = DBConnectionManager.getConnection()){
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
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<AdoptDTO> addMyAdoptManager(String shelterName) {
		List<AdoptDTO> dtos = new ArrayList<>();
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(Define.MANAGER_ADOPT);
			pstmt.setString(1, shelterName);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dtos.add(new AdoptDTO(rs.getString("name"),
									rs.getString("address"),
									rs.getString("number"),
									rs.getString("email"),
									rs.getString("age"),
									rs.getString("sex"),
									rs.getString("job"),
									rs.getString("maritalStatus"),
									rs.getString("visitDate"),
									rs.getString("animalId"),
									rs.getString("raisedPet"),
									rs.getString("sizeFamily"),
									rs.getString("permission"),
									rs.getInt("careID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public static List<ApplyDTO> addMyAdopt(String userName) {
		List<ApplyDTO> dtos = new ArrayList<>();
		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(Define.ADD_ADOPT);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dtos.add(new ApplyDTO(rs.getInt("id"), rs.getString("permission")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;
	}
	
}
