package ver1.parsing;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class JsonAnimalDTO {

	response response;

	@Data
	class response {
		header header;
		body body;
	}

	@Data
	class header {
		int reqNo;
		String resultCode;
		String resultMsg;
	}

	@Data
	class body {
		items items;
	}

	@Data
	class items {
		List<item> item = new ArrayList<>();
	}

	@Data
	class item {
		String kindCd;
		String knm;
	}
}
