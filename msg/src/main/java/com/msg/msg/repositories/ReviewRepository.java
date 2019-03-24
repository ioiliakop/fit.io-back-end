package com.msg.msg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msg.msg.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

	@Query(value = "Select review.id, review.fk_session_id, review.comment, review.date from review,training_session "
			+ "where review.fk_session_id = ?1", nativeQuery = true)
	Review getSessionComment(int idtraining_session);
}
