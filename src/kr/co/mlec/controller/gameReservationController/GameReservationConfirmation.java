package kr.co.mlec.controller.gameReservationController;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.dao.GameReservationMapper;
import kr.co.mlec.domain.GameReservation;
import kr.co.mlec.domain.LogIn;
import kr.co.mlec.domain.Member;

public class GameReservationConfirmation extends ScannerController{
	private GameReservationMapper mapper;
	Member member = null;
	SimpleDateFormat sdf;
	String id = "x";
	List<GameReservation> list = null;
	
	 public GameReservationConfirmation(String id) {
		 this.id = id;
      SqlSession session = MyAppSqlConfig.getSqlSession();
      mapper = session.getMapper(GameReservationMapper.class);
      sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
      //로그인 아이디 넘겨받기.
      member = LogIn.getId();
	}
	
	
	public void service() {
		if(!id.equals("x")) list = mapper.selectGameReservationInfo(id);
		else {
			list = mapper.selectGameReservationByTicketNumber(Integer.parseInt(input("티켓번호를 입력해주세요 :")));
		}
		System.out.println();
		System.out.println(id + "님의 예매 내역입니다.");
		System.out.println();
		for(GameReservation gr : list) {
			System.out.printf(
					"경기날짜 : %s %s vs %s 좌석 : %d%n" , 
					sdf.format(gr.getGameDate()), gr.getHomeTeam(), gr.getAwayTeam(), gr.getSeatNo(), gr.getTicketNumber()
					);
		}
		System.out.println();
		return;
	}
}
