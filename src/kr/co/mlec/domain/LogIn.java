package kr.co.mlec.domain;

public class LogIn {
	//로그인시 아이디 저장..
	
	static Member idInfo;
	
	public static void setId(Member member) {
		idInfo = member;
	}
	
	public static Member getId() {
		return idInfo;
	}

}