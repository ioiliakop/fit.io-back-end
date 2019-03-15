package com.msg.msg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.Message;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.MessageRepository;
import com.msg.msg.repositories.UserRepository;

@RestController
@RequestMapping("/messages")
public class MsgController {

	@Autowired
	public MessageRepository messageRepository;

	@Autowired
	public UserRepository userRepository;

	@GetMapping("/sent/{fk_sender_id}")
	public List<Message> getSentMessages(@PathVariable int fk_sender_id) {
		return messageRepository.findSentMessages(fk_sender_id);
	}

	@GetMapping("/inbox/{fk_receiver_id}")	
	public List<Message> getInboxMessages(@PathVariable int fk_receiver_id) {
		return messageRepository.findInboxMessages(fk_receiver_id);
	}

	@GetMapping("/UsersMsg/{fk_sender_id}/{fk_receiver_id}")
	public List<Message> getUserMessages(@PathVariable int fk_sender_id, @PathVariable int fk_receiver_id) {
		return messageRepository.findUserMessages(fk_receiver_id, fk_sender_id, fk_sender_id, fk_receiver_id);
	}
	
	@PutMapping("/save/{fk_sender_id}/{fk_receiver_id}")
	public void sendMessage(@PathVariable int fk_sender_id,@PathVariable int fk_receiver_id, @RequestBody String content) {
		User sender = userRepository.findById(fk_sender_id);
		User receiver = userRepository.findById(fk_receiver_id);
		Message message = new Message(sender,receiver,content);
		messageRepository.save(message);
	}
	
}
