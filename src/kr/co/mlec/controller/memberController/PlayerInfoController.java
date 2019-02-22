package kr.co.mlec.controller.memberController;

import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;

public class PlayerInfoController extends ScannerController {
	
	public void service() {
		while(true) {
			switch (menu()) {
			case 1:
				// sk 선수단 정보 보기
				SKwyvernsPlayerInfo sk = new SKwyvernsPlayerInfo();
				sk.service();
				break;
			case 0:
				// 이전 (로그인후 화면으로)
				return;
			default:
				System.out.println("죄송합니다.");
				System.out.println("준비중입니다..");
				
			}
		}
	}


	public int menu() {
		System.out.println();
		System.out.println("선수단 정보 보기");
		UtilController.print(30, "=");
		System.out.println("1. SK 와이번스");
		System.out.println("2. LG 트윈스");
		System.out.println("3. 두산 베어스");
		System.out.println("4. 롯데 자이언츠");
		System.out.println("5. 기아 타이거즈");
		System.out.println("6. 한화 이글스");
		System.out.println("7. KT 위즈");
		System.out.println("8. 삼성 라이온즈");
		System.out.println("9. NC 다이노스");
		System.out.println("10. 넥센 히어로즈");
		System.out.println("0. 이전");
		UtilController.print(30, "=");
		return Integer.parseInt(input("팀을 선택해 주세요 : "));	
	}
}