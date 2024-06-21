package ver1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

	String name;
	String userName;
	String userPassWord;
	String userBirth;
	String authority;
	
}
