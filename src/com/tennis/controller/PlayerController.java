package com.tennis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tennis.model.Player;
import com.tennis.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("player") Player player, 
			BindingResult result){
		
		ArrayList<String> gender=new ArrayList<>();
		gender.add("Male");
		gender.add("Female");
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("gender", gender);
		System.out.println("Register player");
				
		return new ModelAndView("register", "model", model);
	}
	
	@RequestMapping("/savePlayer")
	public ModelAndView savePlayerData(@ModelAttribute("player") Player player, 
			BindingResult result){
		
		playerService.addPlayer(player);
		System.out.println("Save player data");
		return new ModelAndView("redirect:/playerList.html");
	}
	
	@RequestMapping("/playerList")
	public ModelAndView getPlayerList(){
		
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("player", playerService.getAllPlayers());
		return new ModelAndView("playerDetails", model);
	}
}
