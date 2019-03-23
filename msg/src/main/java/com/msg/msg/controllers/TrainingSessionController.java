package com.msg.msg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.Area;
import com.msg.msg.entities.TrainingSession;
import com.msg.msg.entities.TrainingType;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.AreaRepository;
import com.msg.msg.repositories.TokenRepository;
import com.msg.msg.repositories.TrainingSessionRepository;
import com.msg.msg.repositories.TrainingTypeRepository;
import com.msg.msg.repositories.UserRepository;

@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "*")
public class TrainingSessionController {

	@Autowired
	public TrainingSessionRepository trainingSessionRepository;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public TokenRepository tokenRepository;

	@Autowired
	public TrainingTypeRepository trainingTypeRepository;

	@Autowired
	public AreaRepository areaRepository;

//	@GetMapping("/trainer-sessions/{fk_trainer_id}")
//	public List<TrainingSession> getTrainersSessions(@PathVariable int fk_trainer_id) {
//		return trainingSessionRepository.findTrainersSessions(fk_trainer_id);
//	}

//	@GetMapping("/trainer-sessions/{trainerUsername}")
//	public List<TrainingSession> getTrainersSessions(@PathVariable String trainerUsername) {
//		User trainer= userRepository.findByUsername(trainerUsername);
//		return trainingSessionRepository.findTrainersSessions(trainer.getId());
//	}

	@GetMapping("/trainer-sessions")
	public List<TrainingSession> getTrainersSessions(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User trainer = userRepository.findById(id);
		return trainingSessionRepository.findTrainersSessions(trainer.getId());
	}

//	@PostMapping("/trainer-sessions-cancel/{idtraining_session}")
//	public void cancelSession(@PathVariable int idtraining_session) {
//		DatabaseHelper.cancelSession(idtraining_session);
//	}

//	@GetMapping("/client-sessions/{fk_client_id}")
//	public List<TrainingSession> getClientSessions(@PathVariable int fk_client_id) {
//		return trainingSessionRepository.findUserSessions(fk_client_id);
//	}

//	@GetMapping("/client-sessions/{clientUsername}")
//	public List<TrainingSession> getClientSessions(@PathVariable String clientUsername) {
//		User client=userRepository.findByUsername(clientUsername);
//		return trainingSessionRepository.findUserSessions(client.getId());
//	}

	@GetMapping("/client-sessions")
	public List<TrainingSession> getClientSessions(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User client = userRepository.findById(id);
		return trainingSessionRepository.findUserSessions(client.getId());
	}

	@PostMapping("/book/{fk_trainer_id}/{idtraining_type}/{idarea}/{date}/{time}")
	public void bookSession(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @PathVariable int fk_trainer_id,
			@PathVariable int idtraining_type, @PathVariable int idarea, @PathVariable String date,
			@PathVariable String time, @RequestBody String comments) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User client = userRepository.findById(id);
		User trainer = userRepository.findById(fk_trainer_id);
		Area area = areaRepository.findById(idarea);
		TrainingType trainingType = trainingTypeRepository.findById(idtraining_type);
		TrainingSession trainingSession = new TrainingSession(client, trainer, area, trainingType, date, time,
				comments);
		trainingSessionRepository.save(trainingSession);

	}
	
	@GetMapping("/comments/{fk_trainer_id}")
	public List<String> gettTrainersComments(@PathVariable int fk_trainer_id) {
		return trainingSessionRepository.trainersComments(fk_trainer_id);
	}

}
