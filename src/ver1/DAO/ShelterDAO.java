package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ver1.DTO.ApplySubmitDTO;
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
				if (sido.equals(rs.getString("sido")) && sigungu.equals(rs.getString("sigungu"))) {
					dto.add(new ShelterDTO(rs.getString("sido"), rs.getString("sigungu"), rs.getString("careNm"),
							rs.getString("careTel"), rs.getString("careAddr")));
				} else if (sido.equals(rs.getString("sido")) && sigungu.equals("전체")) {
					dto.add(new ShelterDTO(rs.getString("sido"), rs.getString("sigungu"), rs.getString("careNm"),
							rs.getString("careTel"), rs.getString("careAddr")));
				} else if (sido.equals("전국")) {
					dto.add(new ShelterDTO(rs.getString("sido"), rs.getString("sigungu"), rs.getString("careNm"),
							rs.getString("careTel"), rs.getString("careAddr")));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public static int searchCareId(int id) {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.SEARCH_SHELTER);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getInt("s.careId");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int searchCareIdApply(int id) {
		try (Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(Define.SHELTER_CARE_APPLY);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.getInt("s.careId");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static String searchShelter(int id) {
		String shelterName = null;
	        try (
	            Connection conn = DBConnectionManager.getConnection();
	        ) {
	        	PreparedStatement stmt = conn.prepareStatement(Define.SHELTER_CARE_APPLY);
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                shelterName = rs.getString("careNm");
	                System.out.println("검색 결과: " + shelterName);
	            } else {
	                System.out.println("해당하는 보호소 아이디에 대한 결과가 없습니다.");
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return shelterName;
	    }
	
	public static int searchShelter(String careNm) {
		int shelterId = 0;
		try (
				Connection conn = DBConnectionManager.getConnection();
				) {
			PreparedStatement stmt = conn.prepareStatement(Define.SHELTER_CARE_APPLY);
			stmt.setString(1, careNm);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				shelterId = rs.getInt("careId");
				System.out.println("검색 결과: " + shelterId);
			} else {
				System.out.println("해당하는 보호소 아이디에 대한 결과가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shelterId;
	}
		
		public static void addAnimalInfo(ApplySubmitDTO applySubmitDTO) {
			ApplySubmitDTO dto = applySubmitDTO;
			try (Connection conn = DBConnectionManager.getConnection()){
				PreparedStatement pstmt = conn.prepareStatement(Define.SHELTER_APPLY_SUBMIT);
				pstmt.setInt(1, dto.getId());
				pstmt.setString(2, dto.getKindCd());
				pstmt.setString(3, dto.getColorCd());
				pstmt.setString(4, dto.getAge());
				pstmt.setString(5, dto.getWeight());
				pstmt.setString(6, dto.getProcessState());
				pstmt.setString(7, dto.getSexCd());
				pstmt.setString(8, dto.getNeuterYn());
				pstmt.setString(9, dto.getSpecialMark());
				pstmt.setInt(10, dto.getCareId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

