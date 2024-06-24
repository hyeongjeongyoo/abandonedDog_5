package ver1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptDTO {

	String name;
	String address;
	String number;
	String email;
	String age;
	String sex;
	String job;
	String maritalStatus;
	String visitDate;
	String animalId;
	String raisedPet;
	String sizeFamily;
	String permission;
	int careId;

}
