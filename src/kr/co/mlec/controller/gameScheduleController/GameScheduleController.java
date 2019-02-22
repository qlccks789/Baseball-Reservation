package kr.co.mlec.controller.gameScheduleController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.controller.UtilController;
import kr.co.mlec.dao.GameScheduleMapper;
import kr.co.mlec.domain.GameSchedule;

public class GameScheduleController extends ScannerController{
	private GameScheduleMapper mapper;
	SimpleDateFormat sdf;
	public GameScheduleController() {
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(GameScheduleMapper.class);
	}
	
	public void service() {
		System.out.println();
		System.out.println("경기일정 입니다.");
		UtilController.print(30, "=");
		List<GameSchedule> list = mapper.selectGameSchedule();
		int i = 0; 
		for (GameSchedule gs : list) {
//			System.out.println(gs.getGameNo() + ". " + sdf.format(gs.getGameDate()) + " --- " + gs.getHomeTeam() + "vs" + gs.getAwayTeam());
			System.out.printf("%2d. %s --- %s vs %s%n", gs.getGameNo(), sdf.format(gs.getGameDate()), gs.getHomeTeam(), gs.getAwayTeam());
		}
		UtilController.print(30, "=");
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		GameScheduleController gsc = new GameScheduleController();
		gsc.service();
	}
}
