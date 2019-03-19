package com.msg.msg.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.User;
import com.msg.msg.repositories.UserRepository;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class RegisterController {

	@Autowired
	public UserRepository userRepository;

	@PostMapping("/save")
	public void registerUser(@Valid @RequestBody User user) {
      User user2 = userRepository.findByUsername(user.getUsername());
		if (user2 == null) {
			userRepository.save(user);
		} else {
			throw new RuntimeException("username already exists,try another");
		}
	}

}
