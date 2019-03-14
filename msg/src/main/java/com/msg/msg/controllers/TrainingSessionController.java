package com.msg.msg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.TrainingSession;
import com.msg.msg.repositories.TrainingSessionRepository;

@RestController
@RequestMapping("/find")
public class TrainingSessionController {

	private TrainingSessionRepository trainingSessionRepository;

	@Autowired
	public TrainingSessionController(TrainingSessionRepository trainingSessionRepository) {
		this.trainingSessionRepository = trainingSessionRepository;
	}

	@GetMapping("/trainer-sessions/{fk_trainer_id}")
	public List<TrainingSession> getTrainersSessions(@PathVariable int fk_trainer_id) {
		return trainingSessionRepository.findTrainersSessions(fk_trainer_id);
	}

	@GetMapping("/client-sessions/{fk_client_id}")
	public List<TrainingSession> getClientSessions(@PathVariable int fk_client_id) {
		return trainingSessionRepository.findUserSessions(fk_client_id);
	}

}
