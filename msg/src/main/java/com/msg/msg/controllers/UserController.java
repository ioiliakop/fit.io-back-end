package com.msg.msg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.TrainingType;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.AreaRepository;
import com.msg.msg.repositories.TrainingTypeRepository;
import com.msg.msg.repositories.UserRepository;

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

	
	@GetMapping("/trainer/{specialization_title}/{city}")
	public List<User> getYourTrainer(@PathVariable String specialization_title,@PathVariable String city) {
		return userRepository.findTrainerByAreaAndType(specialization_title, city);
	}
	
	@GetMapping("/trainer/{specialization_title}/{city}/{price}")
	public List<User> getYourTrainer(@PathVariable String specialization_title,@PathVariable String city,@PathVariable double price) {
		return userRepository.findTrainerByAreaAndTypeAndPrice(specialization_title, city, price);
	}

	@GetMapping("trainer-area/{idarea}")
	public List<User> getTrainerByArea(@PathVariable int idarea) {
		return userRepository.findTrainerByArea(idarea );
	}
	
	@GetMapping("trainer-area-price/{idarea}/{price}")
	public List<User> getTrainerByAreaAndPrice(@PathVariable int idarea,@PathVariable double price) {
		return userRepository.findTrainerByAreaAndPrice(idarea, price);
	}

	@GetMapping("trainer-type/{idtraining_type}")
	public List<User> getTrainerByType(@PathVariable int idtraining_type ) {
		return userRepository.findTrainerByType(idtraining_type);
	}
	
	@GetMapping("trainer-type-price/{idtraining_type}/{price}")
	public List<User> getTrainerByTypeAndPrice(@PathVariable int idtraining_type, @PathVariable double price) {
		return userRepository.findTrainerByTypeAndPrice(idtraining_type, price);
	}
	
	@GetMapping("trainer-price/{price}")
	public List<User> getTrainerByPrice(@PathVariable double price){
		return userRepository.findTrainerByPrice(price);
	}
	 
	@PostMapping("trainer-choose-area/{fk_trainer_id}/{fk_area_id}")
	public void chooseArea(@PathVariable int fk_trainer_id,@PathVariable int fk_area_id){
//		DatabaseHelper.trainerArea(fk_trainer_id, fk_area_id);
		areaRepository.addArea(fk_trainer_id, fk_area_id);

		
	}
	
	@PostMapping("trainer-choose-type/{fk_trainer_id}/{fk_training_type}")
	public void trainerSpecialization(@PathVariable int fk_trainer_id,@PathVariable int fk_training_type){
//		DatabaseHelper.trainerSpecialization(fk_trainer_id, fk_training_type);
		trainingTypeRepository.addType(fk_trainer_id, fk_training_type);
	}
	
	@PostMapping("trainer-remove-area/{fk_trainer_id}/{fk_area_id}")
	public void removeArea(@PathVariable int fk_trainer_id,@PathVariable int fk_area_id){
//		DatabaseHelper.removeArea(fk_trainer_id, fk_area_id);
		areaRepository.removeArea(fk_trainer_id, fk_area_id);
	}
	
	@PostMapping("trainer-remove-type/{fk_trainer_id}/{fk_training_type}")
	public void removeType(@PathVariable int fk_trainer_id,@PathVariable int fk_training_type){
//		DatabaseHelper.removeType(fk_trainer_id, fk_training_type);
		trainingTypeRepository.removeType(fk_trainer_id, fk_training_type);
	}
	
	@GetMapping("/trainer-types/{iduser}")
	public List<TrainingType> getTrainersTypes(@PathVariable int iduser) {
		return trainingTypeRepository.findTrainersTypes(iduser);
	}
	

}
