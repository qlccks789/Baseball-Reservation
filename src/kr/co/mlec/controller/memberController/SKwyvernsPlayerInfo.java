package kr.co.mlec.controller.memberController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.controller.ScannerController;
import kr.co.mlec.dao.PlayerMapper;
import kr.co.mlec.domain.Player;

public class SKwyvernsPlayerInfo extends ScannerController{

	private PlayerMapper mapper;
	
	public SKwyvernsPlayerInfo() {
      SqlSession session = MyAppSqlConfig.getSqlSession();
      mapper = session.getMapper(PlayerMapper.class);
	}
	
	public void service() {
		List<Player> list = mapper.selectPlayerInfo();
		System.out.println("==========================");
		for (Player p : list) {
			System.out.println("이름 : " + p.getPlayerName());
			System.out.println("포지션 : " + p.getPosition());
			System.out.println("나이 : " + p.getAge());
			System.out.println("등번호 : " + p.getBackNumber());
			System.out.println("=========================");
		}
	}
}
