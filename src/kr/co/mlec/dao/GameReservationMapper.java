package kr.co.mlec.dao;

import java.util.List;

import kr.co.mlec.domain.GameReservation;

public interface GameReservationMapper {
	List<GameReservation> insertGameResevationInfo(GameReservation gameReservation);
	void insertReservation(GameReservation gr);
	List<GameReservation> selectGameReservationInfo(String id);
}
