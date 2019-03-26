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
import com.msg.msg.entities.Review;
import com.msg.msg.entities.TrainingSession;
import com.msg.msg.entities.TrainingType;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.AreaRepository;
import com.msg.msg.repositories.ReviewRepository;
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

	@Autowired
	public ReviewRepository reviewRepository;

	@GetMapping("/trainer-sessions")
	public List<TrainingSession> getTrainersSessions(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User trainer = userRepository.findById(id);
		return trainingSessionRepository.findTrainersSessions(trainer.getId());
	}

	@GetMapping("/trainer-sessions-date/{date}")
	public List<TrainingSession> getTrainersSessionsByDate(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric,
			@PathVariable String date) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User trainer = userRepository.findById(id);
		return trainingSessionRepository.findTrainersSessionsByDate(trainer.getId(), date);
	}

	@GetMapping("/client-sessions")
	public List<TrainingSession> getClientSessions(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User client = userRepository.findById(id);
		return trainingSessionRepository.findUserSessions(client.getId());
	}

	@GetMapping("/client-sessions-date/{date}")
	public List<TrainingSession> getCientssSessionsByDate(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric,
			@PathVariable String date) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User client = userRepository.findById(id);
		return trainingSessionRepository.findUserSessionsBydate(client.getId(), date);
	}

	@PostMapping("/book/{fk_trainer_id}/{idtraining_type}/{idarea}/{date}/{time}")
	public void bookSession(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @PathVariable int fk_trainer_id,
			@PathVariable int idtraining_type, @PathVariable int idarea, @PathVariable String date,
			@PathVariable String time) {
		int id = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User client = userRepository.findById(id);
		User trainer = userRepository.findById(fk_trainer_id);
		Area area = areaRepository.findById(idarea);
		TrainingType trainingType = trainingTypeRepository.findById(idtraining_type);
		TrainingSession trainingSession = new TrainingSession(client, trainer, area, trainingType, date, time);
		trainingSessionRepository.save(trainingSession);

	}

	@GetMapping("/review/{idtraining_session}")
	public Review getSessionReview(@PathVariable int idtraining_session) {
		return reviewRepository.getSessionComment(idtraining_session);
	}

	@GetMapping("/review-trainer/{fk_trainer_id}")
	public List<Review> getTrainerReview(@PathVariable int fk_trainer_id) {
		return reviewRepository.getTrainerComments(fk_trainer_id);
	}

	@PostMapping("/add-comment/{idtraining_session}")
	public void reviewSession(@PathVariable int idtraining_session, @RequestBody String comment) {
		TrainingSession trainingSession = trainingSessionRepository.findById(idtraining_session);
		Review review = new Review(trainingSession, comment);
		reviewRepository.save(review);
	}

//	@PostMapping("/trainer-sessions-cancel/{idtraining_session}")
//	public void cancelSession(@PathVariable int idtraining_session) {
//		DatabaseHelper.cancelSession(idtraining_session);
//	}

}
