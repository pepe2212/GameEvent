package com.truelogic.playersProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truelogic.playersProject.client.KafkaClient;
import com.truelogic.playersProject.model.Player;
import com.truelogic.playersProject.model.Response;
import com.truelogic.playersProject.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	KafkaClient client;
	
	private static final String EXPERT="expert";
	private static final String NOVICE="novice";
	
	public Response gameEvent(List<Player> list) {
		Response result = new Response();  
		List<String> events= new ArrayList<>();
		for (Player player : list) {
			if(player.getType().equalsIgnoreCase(EXPERT)) {
				playerRepository.save(player);
				events.add("player "+player.getName()+" stored in DB");
				}
			if(!player.getType().equalsIgnoreCase(EXPERT) && !player.getType().equalsIgnoreCase(NOVICE))
				{events.add("player "+player.getName()+" did not fit");}
			if(player.getType().equalsIgnoreCase(NOVICE))	
			{
				client.sendMessage(player);
			events.add("player "+player.getName()+" sent to Kafka topic");
			}
			}
		
		result.setResult(events);
		return result;
	}
	
	
	
}
