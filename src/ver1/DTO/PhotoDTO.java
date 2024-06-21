package ver1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDTO {
	
	String careNm;
	int id;
	String kindCd;
	String colorCd;
	String age;
	String weight;
	String sexCd;
	String neuterYn;
	String specialMark;
	String popfile;
	
	public PhotoDTO(String popfile) {
		this.popfile = popfile;
	}
	
}
