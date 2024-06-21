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

	public static final String SIDO_PARSING_DATA = " insert into sido(orgCd, orgdownNm) values (?, ?) ";
	
	public static final String SIGUNGU_PARSING_DATA = " insert into sigungu(uprCd, orgCd, orgdownNm) values (?, ?, ?) ";
	
	public static final String SHELTER = "insert into shelter(orgCd, careRegNo, careNm) values (?, ?, ?)";
	
	public static final String ALL_VIEW_ANIMAL_DETAILS = " select * from animal_details where processState like '보호%' order by id desc ";
	
	public static final String JOIN_VIEW_ANIMAL_DETAILS(String field) {
		String query = " select * from animal_details where " + field + " like ? ";
		
		return query;
	}
	
	public static final String MAIN_PHOTO = " select popfile from photo order by rand() limit 1 ";
	
	public static final String SELECT_SIDO = " select * from sido ";
	
	public static final String SELECT_SIGUNGU = " select sido.orgdownNm as sido,"
													+ " sigungu.orgdownNm as sigungu"
													+ " from sido"
													+ " join sigungu"
													+ " on sido.orgCd = sigungu.uprCd ";
	
	public static final String SELECT_SHELTER = " select d.orgdownNm as sido,"
													+ " g.orgdownNm as sigungu,"
													+ " s.careNm as careNm,"
													+ " c.careTel as careTel,"
													+ " c.careAddr as careAddr"
													+ " from sido as d"
													+ " join sigungu as g"
													+ " on d.orgCd = g.uprCd"
													+ " join shelter as s"
													+ " on s.orgCd = g.orgCd"
													+ " join care as c"
													+ " on s.careNm = c.careNm"
													+ " group by c.careNm ";

}
