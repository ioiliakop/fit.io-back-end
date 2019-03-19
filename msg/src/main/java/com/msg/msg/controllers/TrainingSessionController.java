package com.msg.msg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.TrainingSession;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.TrainingSessionRepository;
import com.msg.msg.repositories.UserRepository;

@RestController
@RequestMapping("/find")
@CrossOrigin(origins = "*")
public class TrainingSessionController {

	@Autowired
	public TrainingSessionRepository trainingSessionRepository;

	@Autowired
	public UserRepository userRepository;
	

//	@GetMapping("/trainer-sessions/{fk_trainer_id}")
//	public List<TrainingSession> getTrainersSessions(@PathVariable int fk_trainer_id) {
//		return trainingSessionRepository.findTrainersSessions(fk_trainer_id);
//	}
	
	@GetMapping("/trainer-sessions/{trainerUsername}")
	public List<TrainingSession> getTrainersSessions(@PathVariable String trainerUsername) {
		User trainer= userRepository.findByUsername(trainerUsername);
		return trainingSessionRepository.findTrainersSessions(trainer.getId());
	}

//	@GetMapping("/client-sessions/{fk_client_id}")
//	public List<TrainingSession> getClientSessions(@PathVariable int fk_client_id) {
//		return trainingSessionRepository.findUserSessions(fk_client_id);
//	}
	
	@GetMapping("/client-sessions/{clientUsername}")
	public List<TrainingSession> getClientSessions(@PathVariable String clientUsername) {
		User client=userRepository.findByUsername(clientUsername);
		return trainingSessionRepository.findUserSessions(client.getId());
	}

}
