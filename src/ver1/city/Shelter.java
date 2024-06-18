package ver1.city;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

public class Shelter {

	// 보호소
	//public static final int SEOUL_HOMEPROTECT = 6119999;
	public static final int SEOUL_GANGNAM = 3220000;
	public static final int SEOUL_GANGDONG = 3240000;
	public static final int SEOUL_GANGBUK = 3080000;
	public static final int SEOUL_GANGSEO = 3150000;
	//public static final int SEOUL_HOMEPROTECT = 3200000;
	
	

	
	
	public static String shelter(int upr_cd, int org_cd) {
		String url = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/shelter"
				+ "?upr_cd=" + Sigungu.sigungu(upr_cd)
				+ "&org_cd=" + org_cd
				+ "&serviceKey=palsG47GgfoxfBI5IvepO%2Bs%2BzSWEnnxl74qGa%2FkxbmgoHz4R%2BNYSYXYxeaPeMmUgYDU1V%2BevDZ3g6IoveoEGHQ%3D%3D"
				+ "&_type=json";
		
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Map<String, Integer> sigungu = new HashMap<String, Integer>();
		sigungu.put("서울특별시", 6119999);
		
	}// end of main
	
	
	
	
	
	
	
}// end of class
