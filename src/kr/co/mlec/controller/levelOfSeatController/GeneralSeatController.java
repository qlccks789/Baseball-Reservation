package kr.co.mlec.controller.levelOfSeatController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.controller.memberController.MemberController;
import kr.co.mlec.dao.GameReservationMapper;
import kr.co.mlec.dao.LevelOfSeatMapper;
import kr.co.mlec.domain.GameReservation;
import kr.co.mlec.domain.LevelOfSeat;
import kr.co.mlec.domain.LogIn;
import kr.co.mlec.domain.Member;

public class GeneralSeatController extends ScannerController {
	// 일반석
	private LevelOfSeatMapper mapper;
	private GameReservationMapper mapper1;
	int gameNo;
	Member member;
	public GeneralSeatController(int gameNo) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(LevelOfSeatMapper.class);
		mapper1 = session.getMapper(GameReservationMapper.class);
		this.gameNo = gameNo;
		member = LogIn.getId();
	}
	
	
	
	public void service() {
			while(true) {
			List<LevelOfSeat> list = mapper.selectSeat();
			UtilController.print(30, "=");
			System.out.println(mapper.selectSeatInfo());    		 // 좌석등급 출력
			System.out.println("가격 : " + mapper.selectPriceInfo());  // 가격 출력
			System.out.print("좌석 : ");
			for (LevelOfSeat s : list) {
				System.out.print(s.getSeatNo() + "  "); 			// 좌석번호 출력
			}
			System.out.println();
			UtilController.print(30, "=");
			int no = Integer.parseInt(input("예매하실 좌석번호를 입력해 주세요 : "));
			System.out.println(no + "번 좌석을 선택하셨습니다.");
			
			//no를 기준으로 같은 열에 있는 is_res가 1인지 2인지 구분
			LevelOfSeat los = new LevelOfSeat();
			los.setGameNo(gameNo);
			los.setSeatNo(no);
			int isRes = mapper.selectIsReByNo(los); // -> 1이면 빈 자리, 2면 예약된 자리
			
			
			
			if(isRes == 1) {
				System.out.println();
				System.out.println("1. 결제 진행");
				System.out.println("0. 좌석 다시 선택(이전)");
				UtilController.print(30, "=");
				int num = Integer.parseInt(input("번호를 선택해주세요 : "));
				if (num == 0) {
					return;
				
				} else if (num == 1){
					// DB에 회원 정보 저장하기 (insert)
					GameReservation gr = new GameReservation();
					gr.setGameNo(gameNo);
					gr.setSeatNo(no);
					gr.setMemberId(member.getMemberId());
					mapper1.insertReservation(gr);					
					
					// 경기가 끝나고 isRes 를 다시 전부 1번으로 바꿔줘야 한다.
					
					//is Res 2로바꿔서 저장하기
					mapper.updateIsRes(los);
					
					System.out.println("결제가 완료 되었습니다.");
					MemberController mc = new MemberController();
					mc.service();
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}else {
				System.out.println("이미 예약된 좌석입니다.");
				return;
			}
			
			
		}	
	}
	
	
	
}
