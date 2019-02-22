package kr.co.mlec.dao;

import java.util.List;

import kr.co.mlec.domain.Player;

public interface PlayerMapper {
	List<Player> selectPlayerInfo();
}
