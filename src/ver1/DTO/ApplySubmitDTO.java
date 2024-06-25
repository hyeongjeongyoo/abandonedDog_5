package ver1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplySubmitDTO {
	
	int id;
	String kindCd;
	String colorCd;
	String age;
	String weight;
	String processState;
	String sexCd;
	String neuterYn;
	String specialMark;
	int emp_no;
	int careId;
	
}
