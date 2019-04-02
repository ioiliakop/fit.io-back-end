package com.msg.msg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.msg.msg.entities.Review;

@CrossOrigin("*")
@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Integer>{

	@Query(value = "SELECT review.id, review.fk_session_id, review.comment, review.date, review.rating FROM review,training_session "
			+ "WHERE review.fk_session_id = ?1", nativeQuery = true)
	Review getSessionComment(int idtraining_session);
	
	@Query(value = "SELECT review.id, review.fk_session_id, review.comment, review.date, review.rating FROM review,training_session,user "
			+ "WHERE review.fk_session_id = idtraining_session AND training_session.fk_trainer_id = user.iduser AND user.iduser = ?1 LIMIT ?2,?3", nativeQuery = true)
	List<Review> getTrainerComments(int fk_trainer_id, int index1, int index2);
}
