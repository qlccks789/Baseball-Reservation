package kr.co.mlec.controller.baseballController;


import kr.co.mlec.controller.Controller;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;

public class BaseballController extends ScannerController {
	// 첫 메인화면

	public void service() {
		System.out.println("반갑습니다. SK행복드림구장입니다.");
		while(true) {
			Controller ctrl = null;
			switch(menu()) {
			case 1:
				ctrl = new LogInController();
				break;
			case 2:
				ctrl = new InsertMemberInfoController();
				break;
			case 0:
				exit();
				break;
			default:
				System.out.println("잘못된 메뉴번호입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			if(ctrl != null) {
				ctrl.service();
			}
		}
	}
	
	
	public int menu() {
		UtilController.print(30, "=");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 종료");
		UtilController.print(30, "=");
		return Integer.parseInt(input("선택하세요: "));
	}
	
	public void exit() {
		System.out.println("종료합니다.");
		System.exit(0);
	}

}