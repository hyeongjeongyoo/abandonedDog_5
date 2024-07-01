 package ver1.parsing;

public class ParsingUrl {

	public static String SIDO = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido" + "?numOfRows=17"
			+ "&serviceKey=서비스키"
			+ "&_type=json";

	public static String SIGUNGU = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu" + ""
			+ "&serviceKey=서비스키"
			+ "&_type=json";

	public static String SHELTER = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter" + ""
			+ "&serviceKey=서비스키"
			+ "&_type=json";

	public static String KIND_DOG = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind" + "?up_kind_cd=417000"
			+ "&serviceKey=서비스키"
			+ "&_type=json";

	public static String KIND_CAT = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind" + "?up_kind_cd=422400"
			+ "&serviceKey=서비스키"
			+ "&_type=json";

	public static String AbandonmentPublic(int startDate, int endDate, int pageNo) {
		String url = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic" + "?bgnde=" + startDate
				+ "&endde=" + endDate + "&pageNo=" + pageNo + "&numOfRows=1000"
				+ "&serviceKey=서비스키"
				+ "&_type=json";
		return url;
	}

}
