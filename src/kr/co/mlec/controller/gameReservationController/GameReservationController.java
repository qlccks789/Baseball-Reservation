package kr.co.mlec.controller.gameReservationController;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.controller.levelOfSeatController.LevelOfSeatController;
import kr.co.mlec.dao.GameScheduleMapper;
import kr.co.mlec.domain.GameSchedule;

public class GameReservationController extends ScannerController{
	private GameScheduleMapper mapper;
	SimpleDateFormat sdf;
	private String id = "x";
	public GameReservationController(String id) {
		this.id = id;
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(GameScheduleMapper.class);
	}
	
	public void service() {
		System.out.println();
		System.out.println("경기일정 입니다.");
		UtilController.print(30, "=");
		
		List<GameSchedule> list = mapper.selectGameSchedule(); 
		for (GameSchedule gs : list) {
//			System.out.println(gs.getGameNo() + ". " + sdf.format(gs.getGameDate()) + " --- " + gs.getHomeTeam() + "vs" + gs.getAwayTeam());
			System.out.printf("%2d. %s --- %s vs %s%n", gs.getGameNo(), sdf.format(gs.getGameDate()), gs.getHomeTeam(), gs.getAwayTeam());
		}
		UtilController.print(30, "=");
		int gameNo = Integer.parseInt(input("예매할 경기에 해당하는 번호를 입력하세요 : "));

		for (int i=0; i<list.size(); i++) {
			GameSchedule gs = new GameSchedule();
			
			if(gameNo == i) {
				// 좌석클래스로 보내자
				LevelOfSeatController losc = new LevelOfSeatController(gameNo,id);
				losc.service();			
				}
			}
		}
	
}
