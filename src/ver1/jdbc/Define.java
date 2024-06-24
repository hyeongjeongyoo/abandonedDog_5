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
	
	public static final String INSERT_APPLY_ADOPT = " insert into adopt_apply(name, address, number, email, age, sex, job, "
														+ "maritalStatus, visitDate, animalId, raisedPet, sizeFamily, permission, careID)\r\n"
														+ "values\r\n"
														+ "	(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '승인대기', ?) ";
	
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
	
	public static final String SEARCH_ABANDON = " select c.careNm, "
													+ "ad.id, ad.kindCd, "
													+ "ad.colorCd, ad.age, "
													+ "ad.weight, ad.sexCd, "
													+ "ad.neuterYn, ad.specialMark, "
													+ " p.popfile"
													+ " from animal_details as ad"
													+ " join care as c"
													+ " on ad.careId = c.careId"
													+ " join photo as p"
													+ " on ad.id = p.id "
													+ " where ad.id = ?";

	public static final String SELECT_INTEREST = " select d.orgdownNm as sido,"
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
	
	public static final String MY_WRITER_BOARD = " select * from freeboarddb where username = ? ";
	
	public static final String MY_INTEREST_BOARD = " select * from interestdb where userName = ? ";
	
	public static final String INSERT_MY_INTEREST = " insert into interestdb(id, kindCd, addDate, userName) values (?, ?, curdate(), ?) ";

	public static final String CHANGE_NAME = " update user set name = ? where userName = ? ";
	
	public static final String CHANGE_PASSWORD = " update user set userPassWord = ? where userName = ? ";
	
	public static final String CHANGE_PHONE_NUMBER = " update user set userTel = ? where userName = ? ";
	
	public static final String DELETE_INTEREST = " delete from interestdb where id = ? and userName = ? ";
	
	public static final String DELETE_MY_WRITE = " delete from freeboarddb where id = ? and userName = ? ";
	
	public static final String UPDATE_MY_WRITE_TITLE = " update freeboarddb set title = ? where userName = ? and id = ? ";
	
	public static final String UPDATE_MY_WRITE_CONTENT = " update freeboarddb set content = ? where userName = ? and id = ? ";
	
	public static final String SEARCH_SHELTER = " select s.careId from animal_details as a join shelter as s on a.careId = s.careId where a.id = ? ";
}
