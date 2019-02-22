package kr.co.mlec.controller.levelOfSeatController;

import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.controller.gameReservationController.GameReservationController;

public class LevelOfSeatController extends ScannerController {
	int gameNo;
	public LevelOfSeatController() {

	}
	public LevelOfSeatController(int gameNo) {
		this.gameNo = gameNo;
	}
	// 좌석선택 메인화면
	public void service() {		
		while(true) {
			switch (menu()) {
			case 1:
				// 일반석
				GeneralSeatController gsc = new GeneralSeatController(gameNo);
				gsc.service();
				break;
			case 2:
				// VIP석
				VIPSeatController vsc = new VIPSeatController();
				vsc.service();
				break;
			case 0:
				// 이전
				return;
			default:
				System.out.println("잘못된 입력번호 입니다.");
				System.out.println("다시 번호를 선택해 주세요.");
				
			}
		}
	}

	public void back() {
		GameReservationController pc = new GameReservationController();
		pc.service();
	}

	public int menu() {
		System.out.println();
		System.out.println("좌석 선택");
		UtilController.print(30, "=");
		System.out.println("1. 일반석");
		System.out.println("2. VIP석");
		System.out.println("0. 이전");
		UtilController.print(30, "=");
		System.out.println();
		return Integer.parseInt(input("이용하실 좌석을 선택해주세요 : "));
		
	}
	
}
