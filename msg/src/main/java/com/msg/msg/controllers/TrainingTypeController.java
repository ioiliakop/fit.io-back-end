package com.msg.msg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.TrainingType;
import com.msg.msg.repositories.TrainingTypeRepository;

@RestController
@RequestMapping("/types")
public class TrainingTypeController {
	
	
	@Autowired
	public TrainingTypeRepository trainingTypeRepository;
	
	@GetMapping("/all")
	public List<TrainingType> getAllTypes(){
		return trainingTypeRepository.findAll();
	}

}
