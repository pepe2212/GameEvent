package com.truelogic.playersProject.model;

import java.util.List;

import lombok.Data;

@Data
public class PlayerList {

	private List<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
