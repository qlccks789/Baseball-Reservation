package kr.co.mlec.domain;

import java.util.Date;

public class GameSchedule {
	private int gameNo;
	private int homeTeamNo;
	private int awayTeamNo;
	private Date gameDate;
	private String homeTeam;
	private String awayTeam;
	
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public int getGameNo() {
		return gameNo;
	}
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	public int getHomeTeamNo() {
		return homeTeamNo;
	}
	public void setHomeTeamNo(int homeTeamNo) {
		this.homeTeamNo = homeTeamNo;
	}
	public int getAwayTeamNo() {
		return awayTeamNo;
	}
	public void setAwayTeamNo(int awayTeamNo) {
		this.awayTeamNo = awayTeamNo;
	}
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	
}
