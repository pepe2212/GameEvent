package com.truelogic.playersProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truelogic.playersProject.model.PlayerList;
import com.truelogic.playersProject.model.Response;
import com.truelogic.playersProject.service.PlayerService;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
	
	@Autowired
	PlayerService service;

	@PostMapping
	public Response getPlayers(@RequestBody PlayerList listplayer){
	 return service.gameEvent(listplayer.getPlayers());
}
}
