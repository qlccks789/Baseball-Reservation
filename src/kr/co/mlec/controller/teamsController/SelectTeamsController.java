package kr.co.mlec.controller.teamsController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.dao.TeamsMapper;
import kr.co.mlec.domain.Teams;

public class SelectTeamsController {
	private TeamsMapper mapper;
	
	public SelectTeamsController() {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		mapper = session.getMapper(TeamsMapper.class);
	}
	
	void selectTeams(){
		List<Teams> list = mapper.selectTeams();
		for (Teams teams : list) {
//			System.out.println("팀 번호 : " + teams.getTeamNo() +" 팀 이름 : " + teams.getTeamName());
//			System.out.printf("%d번 팀 : %s%n", teams.getTeamNo(), teams.getTeamName());
			
			System.out.println("팀 번호 : " + teams.getTeamNo());
			System.out.println("팀 이름 : " + teams.getTeamName());
			
		}
	}
	
	public static void main(String[] args) {
		SelectTeamsController stc = new SelectTeamsController();
		stc.selectTeams();
	}
}
