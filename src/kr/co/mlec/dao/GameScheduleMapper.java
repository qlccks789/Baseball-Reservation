package kr.co.mlec.dao;

import java.util.List;

import kr.co.mlec.domain.GameSchedule;

public interface GameScheduleMapper {
	List<GameSchedule> selectGameSchedule();
	public String getHomeTeam(int no);
	public String getAwayTeam(int no);
}
