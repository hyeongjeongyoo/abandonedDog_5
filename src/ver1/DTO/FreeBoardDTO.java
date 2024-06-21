package ver1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoardDTO {

	int id;
	String title;
	String username;
	String content;
	String create_date;
	
}
