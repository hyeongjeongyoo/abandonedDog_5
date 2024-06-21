package ver1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import lombok.Data;
import ver1.jdbc.DBConnectionManager;

@Data
public class JoinDAO {

	public static boolean booleanSelectJoin(String userName, String name, String userPassWord, String userBrith,
			String userTel) {
		boolean flag = false;
		String selectJoin = " SELECT userName, userPassWord FROM user WHERE userName = ? ";
		String insertJoin = " INSERT INTO user(userName, name, userPassword, userBirth, userTel) VALUES( ?, ?, ?, ?, ?) ";

		try (Connection conn1 = DBConnectionManager.getConnection()) {

			PreparedStatement pstmt1 = conn1.prepareStatement(selectJoin);
			pstmt1.setString(1, userName);
			ResultSet rs = pstmt1.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
			} else {

				try (Connection conn2 = DBConnectionManager.getConnection()) {
					PreparedStatement pstmt2 = conn2.prepareStatement(insertJoin);
					pstmt2.setString(1, userName);
					pstmt2.setString(2, name);
					pstmt2.setString(3, userPassWord);
					pstmt2.setString(4, userBrith);
					pstmt2.setString(5, userTel);
					pstmt2.executeUpdate();
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public static boolean selectJoinMember(String userName, String name, String userPassWord, String userBrith,
			String userTel, int userDepartmentNo, String userDepartmentName) {
		boolean flag2 = false;
		String selectJoinMem = " SELECT userName, userPassWord FROM user WHERE userName = ? ";
		String insertJoinMem = " INSERT INTO user(userName, name, userPassword, userBirth, userTel, userDepartmentNo, userDepartmentName, authority) VALUES(?, ?, ?, ?, ?, ?, ?, ?) ";
		String selectShelter = " select careId, careNm from shelter where careId = ? and careNm = ? ";

		try (Connection conn3 = DBConnectionManager.getConnection()) {

			PreparedStatement pstmt1 = conn3.prepareStatement(selectJoinMem);
			pstmt1.setString(1, userName);

			ResultSet rs = pstmt1.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				PreparedStatement pstmt2 = conn3.prepareStatement(selectShelter);
				pstmt2.setInt(1, userDepartmentNo);
				pstmt2.setString(2, userDepartmentName);
				rs = pstmt2.executeQuery();

				if (rs.next()) {

					try (Connection conn5 = DBConnectionManager.getConnection()) {
						PreparedStatement pstmt = conn5.prepareStatement(insertJoinMem);

						pstmt.setString(1, userName);
						pstmt.setString(2, name);
						pstmt.setString(3, userPassWord);
						pstmt.setString(4, userBrith);
						pstmt.setString(5, userTel);
						pstmt.setInt(6, userDepartmentNo);
						pstmt.setString(7, userDepartmentName);
						pstmt.setString(8, "manager");
						pstmt.executeUpdate();
						flag2 = true;

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "등록된 보호소가 존재하지 않습니다.", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag2;
	}
}
