package ver1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinDTO {

	String userName;
	String name;
	String userPassWord;
	String userBirth;
	String userTel;
	int userDepartmentNo;
	String userDepartmentName;
}
