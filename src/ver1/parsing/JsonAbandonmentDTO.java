package ver1.parsing;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JsonAbandonmentDTO {

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
		int numOfRows;
		int pageNo;
		int totalCount;
	}

	@Data
	class items {
		List<item> item = new ArrayList<>();
	}

	@Data
	class item {
		String desertionNo;
		String filename;
		String happenDt;
		String happenPlace;
		String kindCd;
		String colorCd;
		String age;
		String weight;
		String noticeNo;
		String noticeSdt;
		String noticeEdt;
		String popfile;
		String processState;
		String sexCd;
		String neuterYn;
		String specialMark;
		String careNm;
		String careTel;
		String careAddr;
		String orgNm;
		String chargeNm;
		String officetel;
	}
}
