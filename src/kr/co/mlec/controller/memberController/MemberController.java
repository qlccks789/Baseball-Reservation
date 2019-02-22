package kr.co.mlec.controller.memberController;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.controller.baseballController.BaseballController;
import kr.co.mlec.controller.gameReservationController.GameReservationConfirmation;
import kr.co.mlec.controller.gameReservationController.GameReservationController;
import kr.co.mlec.controller.gameScheduleController.GameScheduleController;
import kr.co.mlec.dao.MemberMapper;
import kr.co.mlec.domain.LogIn;
import kr.co.mlec.domain.Member;

public class MemberController extends ScannerController {
	 
	private MemberMapper mapper;
	private String id = "x";
	private int num = 0;
	Member member = null;
	
	 public MemberController(int num) {
		 this.num = num;
		 SqlSession session = MyAppSqlConfig.getSqlSession();
		 mapper = session.getMapper(MemberMapper.class);
		 if(num == 1) member = LogIn.getId();
	 }
	
	public void service() {	
		System.out.println();
		if (num == 1) id = member.getMemberId();
		
		System.out.println( id +"님, 환영합니다.");
		while(true) {
			switch(menu()) {
			case 1:
				// 경기일정
				GameScheduleController gsc = new GameScheduleController();
				gsc.service();
				break;
			case 2:
				PlayerInfoController pic = new PlayerInfoController();
				pic.service();
				// 선수단 정보
				break;
			case 3:
				// 입장권 예매
				GameReservationController grc = new GameReservationController(id);
				grc.service();
				break;
			case 4:
				// 예매 확인
				GameReservationConfirmation grcf = new GameReservationConfirmation(id);
				grcf.service();
				break;
			case 5:
				// 회원정보 수정
				if(num == 1) {
					UpdateMemberController umc = new UpdateMemberController();
					umc.service();					
				}else {
					System.out.println("잘못된 메뉴선택입니다.");
					System.out.println("다시 선택해 주세요.");					
				}
				break;
			case 0:
				// 로그아웃
				BaseballController bc = new BaseballController();
				bc.service();
				break;
			default :
				System.out.println("잘못된 메뉴선택입니다.");
				System.out.println("다시 선택해 주세요.");
				return;
			}
		}
	}
	
	
	public int menu() {
		UtilController.print(30, "=");
		System.out.println("1. 경기일정");
		System.out.println("2. 선수단 정보");
		System.out.println("3. 입장권 예매");
		System.out.println("4. 예매 확인");
		if(num == 1) System.out.println("5. 회원정보 수정");
		System.out.println("0. 로그아웃");
		UtilController.print(30, "=");
		return Integer.parseInt(input("선택하세요:"));
	}
	

	
	
	
}