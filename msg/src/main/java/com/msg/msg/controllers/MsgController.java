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
import com.msg.msg.repositories.MessageRepository;

@RestController
@RequestMapping("/messages")
public class MsgController {

	private MessageRepository messageRepository;

	@Autowired
	public MsgController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

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
	
	@PutMapping("/save")
	public void sendMessage(@RequestBody Message message) {
		messageRepository.save(message);
	}
	
}
