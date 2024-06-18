package ver1.jdbc;

public class Define {

	public static final String KIND_PARSING_DATA = " insert into animal(kindCd, knm) values (?, ?) ";
	
	public static final String DETAILS_PARSING_DATA = " insert into animal_details"
														+ "(desertionNo, filename, happenDt, happenPlace, "
														+ "kindCd, colorCd, age, weight, noticeNo, "
														+ "noticeSdt, noticeEdt, popfile, processState, "
														+ "sexCd, neuterYn, specialMark, careNm, careTel, "
														+ "careAddr, orgNm, chargeNm, officetel) "
														+ "values "
														+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	
}
