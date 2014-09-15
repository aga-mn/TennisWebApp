package com.tennis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tennis.model.Player;

@Repository

public class PlayerDaoHibernate implements PlayerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPlayer(Player player) {
		
		sessionFactory.getCurrentSession().save(player);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAllPlayers() {
		
		return sessionFactory.getCurrentSession().createQuery("from Player").list();
	}

}
