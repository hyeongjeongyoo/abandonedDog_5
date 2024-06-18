package ver1.parsing;

import java.util.ArrayList;
import java.util.List;

public class JsonCatDTO {
	response response;

	class response {
		header header;
		body body;
	}

	class header {
		int reqNo;
		String resultCode;
		String resultMsg;
	}

	class body {
		items items;
	}

	class items {
		List<item> item = new ArrayList<>();
	}

	class item {
		String kindCd;
		String knm;
	}
}
