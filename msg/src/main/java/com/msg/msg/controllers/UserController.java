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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.database.DatabaseHelper;
import com.msg.msg.entities.Area;
import com.msg.msg.entities.Result;
import com.msg.msg.entities.Role;
import com.msg.msg.entities.Token;
import com.msg.msg.entities.TrainingType;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.AreaRepository;
import com.msg.msg.repositories.TokenRepository;
import com.msg.msg.repositories.TrainingTypeRepository;
import com.msg.msg.repositories.UserRepository;
import com.msg.msg.validation.Validations;

@RestController
@RequestMapping("/find")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public AreaRepository areaRepository;

	@Autowired
	public TrainingTypeRepository trainingTypeRepository;

	@Autowired
	TokenRepository tokenRepository;

	@GetMapping("/getUser/{id}")
	public User findUser(@PathVariable int id) {
		User user = userRepository.findById(id);
		Validations.validateUser(user);
		return user;
	}

	@GetMapping("/all")
	public Result<User> getAllUsers(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @RequestParam int start,
			@RequestParam int size) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		int count = DatabaseHelper.getUsersCount();
		List<User> users = userRepository.getAllUsers(start, size);
		return new Result<User>(count, users);
	}

	@GetMapping("/trainer/{idtraining_type}/{idarea}")
	public List<User> getYourTrainer(@PathVariable int idtraining_type, @PathVariable int idarea) {
		TrainingType trainingType = trainingTypeRepository.findById(idtraining_type);
		Validations.validateTrainingType(trainingType);
		Area area = areaRepository.findById(idarea);
		Validations.validateArea(area);
		return userRepository.findByTrainerAreasAndTrainerTypes(area, trainingType);
	}

	@GetMapping("/trainer/{idarea}/{idtraining_type}/{price}")
	public List<User> getYourTrainer(@PathVariable int idarea, @PathVariable int idtraining_type,
			@PathVariable double price) {
		Area area = areaRepository.findById(idarea);
		Validations.validateArea(area);
		TrainingType trainingType = trainingTypeRepository.findById(idtraining_type);
		Validations.validateTrainingType(trainingType);
		return userRepository.findByTrainerAreasAndTrainerTypesAndPriceLessThanEqual(area, trainingType, price);
	}

	@GetMapping("trainers-area/{idarea}")
	public List<User> getTrainerByArea(@PathVariable int idarea) {
		Area area = areaRepository.findById(idarea);
		Validations.validateArea(area);
		return userRepository.findByTrainerAreas(area);
	}

	@GetMapping("trainer-area-price/{idarea}/{price}")
	public List<User> getTrainerByAreaAndPrice(@PathVariable int idarea, @PathVariable double price) {
		Area area = areaRepository.findById(idarea);
		Validations.validateArea(area);
		return userRepository.findByTrainerAreasAndPriceLessThanEqual(area, price);
	}

	@GetMapping("byPrice/{priceMax}")
	public List<User> getTrainerByPrice(@PathVariable double priceMax) {
		return userRepository.findByPriceGreaterThanAndPriceLessThanEqual(0, priceMax);
	}

	@GetMapping("all-trainers")
	public List<User> getAllTrainers(@RequestBody Role role) {
		Validations.validateRole(role);
		return userRepository.findByRole(role);
	}

	@GetMapping("trainer-type/{idtraining_type}")
	public List<User> getTrainerByType(@PathVariable int idtraining_type) {
		TrainingType trainingType = trainingTypeRepository.findById(idtraining_type);
		Validations.validateTrainingType(trainingType);
		return userRepository.findByTrainerTypes(trainingType);
	}

	@GetMapping("trainer-type-price/{idtraining_type}/{price}")
	public List<User> getTrainerByTypeAndPrice(@PathVariable int idtraining_type, @PathVariable double price) {
		TrainingType trainingType = trainingTypeRepository.findById(idtraining_type);
		Validations.validateTrainingType(trainingType);
		return userRepository.findByTrainerTypesAndPriceLessThanEqual(trainingType, price);
	}

	@PostMapping("set-price/{iduser}/{price}")
	public void setPrice(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int iduser,
			@PathVariable double price) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		User user = userRepository.findById(iduser);
		user.setPrice(price);
		userRepository.save(user);
	}

	@PostMapping("trainer-choose-area/{fk_trainer_id}/{fk_area_id}")
	public void chooseArea(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int fk_trainer_id,
			@PathVariable int fk_area_id) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		areaRepository.addArea(fk_trainer_id, fk_area_id);
	}

	@PostMapping("trainer-choose-type/{fk_trainer_id}/{fk_training_type}")
	public void trainerSpecialization(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric,
			@PathVariable int fk_trainer_id, @PathVariable int fk_training_type) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		trainingTypeRepository.addType(fk_trainer_id, fk_training_type);
	}

	@PostMapping("trainer-remove-area/{fk_trainer_id}/{fk_area_id}") // maybe
	public void removeArea(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int fk_trainer_id,
			@PathVariable int fk_area_id) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		areaRepository.removeArea(fk_trainer_id, fk_area_id);
	}

	@PostMapping("trainer-remove-type/{fk_trainer_id}/{fk_training_type}") // maybe
	public void removeType(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int fk_trainer_id,
			@PathVariable int fk_training_type) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		trainingTypeRepository.removeType(fk_trainer_id, fk_training_type);
	}

	@PostMapping("/addAreas/{userId}") // maybe
	public void addAreas(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int userId,
			@RequestBody List<Area> areas) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		for (Area area : areas) {
			areaRepository.addArea(userId, area.getId());
		}
	}

	@PostMapping("/addTrainingTypes/{userId}") // maybe
	public void addTrainingTypes(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int userId,
			@RequestBody List<TrainingType> types) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		User user = userRepository.findById(userId);
		Validations.validateUser(user);
		List<TrainingType> TrainingTypesThatTrainerHas = trainingTypeRepository.findByTrainers(user);
		for (TrainingType type : TrainingTypesThatTrainerHas) {
			trainingTypeRepository.removeType(userId, type.getId());
		}
		for (TrainingType type : types) {
			trainingTypeRepository.addType(userId, type.getId());
		}
	}

	@PostMapping("bann-user/{iduser}")
	public void bannUser(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int iduser) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		User user = userRepository.findById(iduser);
		Validations.validateUser(user);
		user.setActiveStatus(0);
		userRepository.save(user);
	}

	@PostMapping("unbann-user/{iduser}")
	public void unBannUser(@RequestHeader(value = "X-MSG-AUTH") String alphanumeric, @PathVariable int iduser) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validations.validateToken(token);
		User user = userRepository.findById(iduser);
		Validations.validateUser(user);
		user.setActiveStatus(1);
		userRepository.save(user);
	}

}
