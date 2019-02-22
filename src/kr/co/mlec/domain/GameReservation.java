package kr.co.mlec.domain;

import java.util.Date;

public class GameReservation {
	private int reservationNo;
	private String memberId;
	private int ticketNumber;
	private int seatNo;
	private int gameNo;
	private int seatReserNo;
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
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	public int getGameNo() {
		return gameNo;
	}
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	public int getSeatReserNo() {
		return seatReserNo;
	}
	public void setSeatReserNo(int seatReserNo) {
		this.seatReserNo = seatReserNo;
	}
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
}
