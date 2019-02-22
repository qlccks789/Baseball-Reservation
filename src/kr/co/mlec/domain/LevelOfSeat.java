package kr.co.mlec.domain;

import java.util.Date;

public class LevelOfSeat {
	private int seatNo;
	private String seatLevel;
	private int price;
	private int gameNo;
	private int seatReserNo;
	private int isRes;
	
	public int getIsRes() {
		return isRes;
	}
	public void setIsRes(int isRes) {
		this.isRes = isRes;
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
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getSeatLevel() {
		return seatLevel;
	}
	public void setSeatLevel(String seatLevel) {
		this.seatLevel = seatLevel;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
