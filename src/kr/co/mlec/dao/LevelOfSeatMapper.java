package kr.co.mlec.dao;

import java.util.List;

import kr.co.mlec.domain.LevelOfSeat;

public interface LevelOfSeatMapper {
	List<LevelOfSeat> selectSeat();
	String selectSeatInfo();
	int selectPriceInfo();
	int selectIsReByNo(LevelOfSeat seat);
	void updateIsRes(LevelOfSeat seat);
}
