package kr.co.mlec.controller.nonMemberController;

import java.util.Scanner;

import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.controller.baseballController.BaseballController;
import kr.co.mlec.controller.gameScheduleController.GameScheduleController;
import kr.co.mlec.controller.memberController.PlayerInfoController;

public class NonMemberController extends ScannerController {
   Scanner sc = new Scanner(System.in);
   
   public void service() {
	  System.out.println();
      System.out.println("반갑습니다. SK행복드림구장입니다.");
      while(true) {
         switch(choice()) {
         case 1:
        	// 경기일정
			GameScheduleController gsc = new GameScheduleController();
			gsc.service();        	 
            break;
         case 2:
        	// 선수단정보
			PlayerInfoController pic = new PlayerInfoController();
			pic.service();
            break;
         case 0:
        	BaseballController bc = new BaseballController();
        	bc.service();
            break;
         default:
        	 System.out.println("잘못된 번호입니다.");
        	 System.out.println("다시 입력해 주세요.");
         }
      }
   }
   
   
   public int choice() {
	  UtilController.print(30, "=");
      System.out.println("1. 경기일정");
      System.out.println("2. 선수단 정보");
      System.out.println("3. 입장권 예매");
      System.out.println("4. 예매 확인");
      System.out.println("0. 이전");
      UtilController.print(30, "=");
      System.out.print("선택하세요:");
      return Integer.parseInt(sc.nextLine());
   }
   
   
}