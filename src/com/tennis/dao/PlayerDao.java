package com.tennis.dao;

import java.util.List;
import com.tennis.model.Player;

public interface PlayerDao {
	
    public void addPlayer(Player player);
    public List<Player> getAllPlayers();
    
}