package com.msg.msg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msg.msg.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Query(value="SELECT * FROM tseam_six_3.message where fk_sender_id=?1", nativeQuery = true)
	List <Message> findSentMessages(int fk_sender_id);
	
	@Query(value="SELECT * FROM tseam_six_3.message where fk_receiver_id=?1", nativeQuery = true)
	List <Message> findInboxMessages(int fk_receiver_id);
	
	@Query(value="SELECT * FROM tseam_six_3.message where fk_receiver_id=?1 and fk_sender_id=?2 or fk_receiver_id=?3 and fk_sender_id=?4", nativeQuery = true)
	List <Message> findUserMessages(int fk_receiver_id,int fk_sender_id,int fk_sender_id1,int fk_receiver_id1);
	
}
