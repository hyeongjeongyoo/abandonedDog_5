package ver1.parsing;

public class ParsingUrl {
	
	public static String SIDO = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido"
			+ "?numOfRows=17"
			+ "&serviceKey=palsG47GgfoxfBI5IvepO%2Bs%2BzSWEnnxl74qGa%2FkxbmgoHz4R%2BNYSYXYxeaPeMmUgYDU1V%2BevDZ3g6IoveoEGHQ%3D%3D"
			+ "&_type=json";
	
	public static String SIGUNGU= "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu"
			+ ""
			+ "&serviceKey=palsG47GgfoxfBI5IvepO%2Bs%2BzSWEnnxl74qGa%2FkxbmgoHz4R%2BNYSYXYxeaPeMmUgYDU1V%2BevDZ3g6IoveoEGHQ%3D%3D"
			+ "&_type=json";

	public static String SHELTER = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter"
			+ ""
			+ "&serviceKey=palsG47GgfoxfBI5IvepO%2Bs%2BzSWEnnxl74qGa%2FkxbmgoHz4R%2BNYSYXYxeaPeMmUgYDU1V%2BevDZ3g6IoveoEGHQ%3D%3D"
			+ "&_type=json";
	
	public static String KIND_DOG = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind"
			+ "?up_kind_cd=417000"
			+ "&serviceKey=h2L2yUU0MSS86UJbB3slU5ZNshufRpQ9eXTCMo2%2Bm2hLIP8rh%2B%2BwQHrNiRWw%2BrSkuQkgHU1H%2FdslG3QfM7cRvQ%3D%3D"
			+ "&_type=json";
	
	public static String KIND_CAT = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind"
			+ "?up_kind_cd=422400"
			+ "&serviceKey=h2L2yUU0MSS86UJbB3slU5ZNshufRpQ9eXTCMo2%2Bm2hLIP8rh%2B%2BwQHrNiRWw%2BrSkuQkgHU1H%2FdslG3QfM7cRvQ%3D%3D"
			+ "&_type=json";
	
	public static String AbandonmentPublic(int startDate, int endDate, int pageNo) {
		String url = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"
				+ "?bgnde=" + startDate
				+ "&endde=" + endDate
				+ "&pageNo=" + pageNo
				+ "&numOfRows=1000"
				+ "&serviceKey=h2L2yUU0MSS86UJbB3slU5ZNshufRpQ9eXTCMo2%2Bm2hLIP8rh%2B%2BwQHrNiRWw%2BrSkuQkgHU1H%2FdslG3QfM7cRvQ%3D%3D"
				+ "&_type=json";
		return url;
	}

}
