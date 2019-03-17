package com.msg.msg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.database.DatabaseHelper;
import com.msg.msg.entities.Token;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.TokenRepository;
import com.msg.msg.repositories.UserRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public TokenRepository tokenRepository;

	@PostMapping("/user/{username}/{password}")
	public Token loginUser(@PathVariable String username, @PathVariable String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		Token token = DatabaseHelper.createToken(user);
		return token;
	}

	@GetMapping("/userFromToken/{alphanumeric}")
	public User getFromToken(@PathVariable String alphanumeric) {
		int userId = DatabaseHelper.getUserIDFromTokenAlphaNumeric(alphanumeric);
		return userRepository.findById(userId);
	}

	@PostMapping("/logout/{alphanumeric}")
	public void logout(@PathVariable String alphanumeric) {
		DatabaseHelper.logOutUser(alphanumeric);
	}
}
