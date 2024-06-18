package ver1.city;


public class Sigungu {

	// 시군구
	public static final int SEOUL = 6110000;
	public static final int BUSAN = 6260000;
	public static final int DAEGU = 6270000;
	public static final int INCHEN = 6280000;
	public static final int GWANGJU = 6290000;
	public static final int SEJONG = 5690000;
	public static final int DAEJEON = 6300000;
	public static final int ULSAN = 6310000;
	public static final int GYEONGGI = 6410000;
	public static final int GWANGONE = 6530000;
	public static final int CHUNGCHEONG_NOTRH = 6430000;
	public static final int CHUNGCHEONG_SOUTH = 6440000;
	public static final int JEONBUK = 6540000;
	public static final int JEONLA = 6460000;
	public static final int GYEONGSANG_NOTRH = 6470000;
	public static final int GYEONGSANG_SOUTH = 6480000;
	public static final int JEJU = 6500000;

	public static String sigungu(int uprCd) {
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sigungu" + "?upr_cd=" + uprCd
				+ "&serviceKey=palsG47GgfoxfBI5IvepO%2Bs%2BzSWEnnxl74qGa%2FkxbmgoHz4R%2BNYSYXYxeaPeMmUgYDU1V%2BevDZ3g6IoveoEGHQ%3D%3D"
				+ "&_type=json";

//		switch (uprCd) {
//		case 1:
//			sigungu(SEOUL);
//			break;
//		case 2:
//			sigungu(BUSAN);
//			break;
//		case 3:
//			sigungu(DAEGU);
//			break;
//		case 4:
//			sigungu(INCHEN);
//			break;
//		case 5:
//			sigungu(GWANGJU);
//			break;
//		case 6:
//			sigungu(SEJONG);
//			break;
//		case 7:
//			sigungu(DAEJEON);
//			break;
//		case 8:
//			sigungu(ULSAN);
//			break;
//		case 9:
//			sigungu(GYEONGGI);
//			break;
//		case 10:
//			sigungu(GWANGONE);
//			break;
//		case 11:
//			sigungu(CHUNGCHEONG_NOTRH);
//			break;
//		case 12:
//			sigungu(CHUNGCHEONG_SOUTH);
//			break;
//		case 13:
//			sigungu(JEONBUK);
//			break;
//		case 14:
//			sigungu(JEONLA);
//			break;
//		case 15:
//			sigungu(GYEONGSANG_NOTRH);
//			break;
//		case 16:
//			sigungu(GYEONGSANG_SOUTH);
//			break;
//		case 17:
//			sigungu(JEJU);
//			break;
//		}
		return url;
	}
}


