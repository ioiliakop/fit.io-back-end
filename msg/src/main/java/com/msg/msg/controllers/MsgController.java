package com.msg.msg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msg.msg.entities.Message;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.MessageRepository;
import com.msg.msg.repositories.TokenRepository;
import com.msg.msg.repositories.UserRepository;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*")
public class MsgController {

	@Autowired
	public MessageRepository messageRepository;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public TokenRepository tokenRepository;
	
//	@GetMapping("/sent/{fk_sender_id}")
//	public List<Message> getSentMessages(@PathVariable int fk_sender_id) {
//		return messageRepository.findSentMessages(fk_sender_id);
//	}

	@GetMapping("/sent")
	public List<Message> getSentMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @RequestParam int index1, @RequestParam int index2) {
		int senderId=tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User sender=userRepository.findById(senderId);
		return messageRepository.findSentMessages(sender.getId(), index1, index2);
	}
	
//	@GetMapping("/inbox/{fk_receiver_id}")	
//	public List<Message> getInboxMessages(@PathVariable int fk_receiver_id) {
//		return messageRepository.findInboxMessages(fk_receiver_id);
//	}
	
	@GetMapping("/inbox")	
	public List<Message> getInboxMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @RequestParam int index1, @RequestParam int index2) {
		int receiverId=tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User receiver=userRepository.findById(receiverId);
		return messageRepository.findInboxMessages(receiver.getId(), index1, index2);
	}

//	@GetMapping("/UsersMsg/{fk_sender_id}/{fk_receiver_id}")
//	public List<Message> getUserMessages(@PathVariable int fk_sender_id, @PathVariable int fk_receiver_id) {
//		return messageRepository.findUserMessages(fk_receiver_id, fk_sender_id, fk_sender_id, fk_receiver_id);
//	}
	
	@GetMapping("/UsersMsg/{receiverUsername}")
	public List<Message> getUserMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @PathVariable String receiverUsername, @RequestParam int index1, @RequestParam int index2) {
		int senderId=tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User sender=userRepository.findById(senderId);
		User receiver=userRepository.findByUsername(receiverUsername);
		return messageRepository.findUserMessages(receiver.getId(), sender.getId(), sender.getId(), receiver.getId(), index1, index2);
	}
	
//	@PutMapping("/save/{fk_sender_id}/{fk_receiver_id}")
//	public void sendMessage(@PathVariable int fk_sender_id,@PathVariable int fk_receiver_id, @RequestBody String content) {
//		User sender = userRepository.findById(fk_sender_id);
//		User receiver = userRepository.findById(fk_receiver_id);
//		Message message = new Message(sender,receiver,content);
//		messageRepository.save(message);
//	}
	
	@PostMapping("/save/{receiverUsername}")
	public void sendMessage(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric,@PathVariable String receiverUsername, @RequestBody String content) {
		int senderId=tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User sender = userRepository.findById(senderId);
		User receiver = userRepository.findByUsername(receiverUsername);
		Message message = new Message(sender,receiver,content);
		messageRepository.save(message);
	}
	
}
