package com.tennis.service;

import java.util.List;

import com.tennis.model.Player;

public interface PlayerService {
	
	public void addPlayer(Player player);
    public List<Player> getAllPlayers();

}
