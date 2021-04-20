package com.truelogic.playersProject.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.truelogic.playersProject.model.Player;

@Service
public class KafkaClient {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(Player player) {
	
		kafkaTemplate.send("novice-players", player);
	}
}
