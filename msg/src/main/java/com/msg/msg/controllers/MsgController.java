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
import com.msg.msg.entities.Message;
import com.msg.msg.entities.Result;
import com.msg.msg.entities.Token;
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

//	@GetMapping("/sent")
//	public List<Message> getSentMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @RequestParam int index1, @RequestParam int index2) {
//		int senderId=tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
//		return messageRepository.findSentMessages(senderId, index1, index2);
//	}

	@GetMapping("/sent")
	public Result getSentMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @RequestParam int index1,
			@RequestParam int index2) {
		int senderId = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		List<Message> msgs = messageRepository.findSentMessages(senderId, index1, index2);
		int count = DatabaseHelper.getSentMsgCount(senderId);
		return new Result(count, msgs);
	}

//	@GetMapping("/sent-count")
//	public int getSentMsgCount(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric) {
//		int senderId=tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
//		return DatabaseHelper.getMsgCount(senderId);
//	}

//	@GetMapping("/inbox/{fk_receiver_id}")	
//	public List<Message> getInboxMessages(@PathVariable int fk_receiver_id) {
//		return messageRepository.findInboxMessages(fk_receiver_id);
//	}

//	@GetMapping("/inbox")	
//	public List<Message> getInboxMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @RequestParam int index1, @RequestParam int index2) {
//		int receiverId=tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
//		return messageRepository.findInboxMessages(receiverId, index1, index2);
//	}

	@GetMapping("/inbox")
	public Result getInboxMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric, @RequestParam int index1,
			@RequestParam int index2) {
		int receiverId = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		List<Message> msgs = messageRepository.findInboxMessages(receiverId, index1, index2);
		int count = DatabaseHelper.getInboxMsgCount(receiverId);
		return new Result(count, msgs);
	}

//	@GetMapping("/UsersMsg/{fk_sender_id}/{fk_receiver_id}")
//	public List<Message> getUserMessages(@PathVariable int fk_sender_id, @PathVariable int fk_receiver_id) {
//		return messageRepository.findUserMessages(fk_receiver_id, fk_sender_id, fk_sender_id, fk_receiver_id);
//	}

	@GetMapping("/UsersMsg/{trainerUsername}/{clientUsername}")
	public Result getUserMessages(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric,
			@PathVariable String trainerUsername, @PathVariable String clientUsername, @RequestParam int index1,
			@RequestParam int index2) {
		Token token = tokenRepository.findByAlphanumeric(tokenAlphanumeric);
		if (token != null) {
			User trainer = userRepository.findByUsername(trainerUsername);
			User client = userRepository.findByUsername(clientUsername);
			List<Message>msgs = messageRepository.findUserMessages(client.getId(), trainer.getId(), trainer.getId(), client.getId(),
					index1, index2);
			int count = DatabaseHelper.getUsersMsgCount(trainer.getId(), client.getId());
			return new Result(count, msgs);
		} else
			throw new RuntimeException("Unauthorized action");
	}

//	@PutMapping("/save/{fk_sender_id}/{fk_receiver_id}")
//	public void sendMessage(@PathVariable int fk_sender_id,@PathVariable int fk_receiver_id, @RequestBody String content) {
//		User sender = userRepository.findById(fk_sender_id);
//		User receiver = userRepository.findById(fk_receiver_id);
//		Message message = new Message(sender,receiver,content);
//		messageRepository.save(message);
//	}

	@PostMapping("/save/{receiverUsername}")
	public void sendMessage(@RequestHeader("X-MSG-AUTH") String tokenAlphanumeric,
			@PathVariable String receiverUsername, @RequestBody String content) {
		int senderId = tokenRepository.getUserIDFromTokenAlphaNumeric(tokenAlphanumeric);
		User sender = userRepository.findById(senderId);
		User receiver = userRepository.findByUsername(receiverUsername);
		Message message = new Message(sender, receiver, content);
		messageRepository.save(message);
	}

}
