package com.msg.msg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msg.msg.entities.TrainingSession;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Integer> {

	@Query(value = "SELECT * FROM tseam_six_3.training_session where fk_trainer_id=?1 order by date desc", nativeQuery = true)
	List<TrainingSession> findTrainersSessions(int fk_trainer_id);

	@Query(value = "SELECT * FROM tseam_six_3.training_session where fk_trainer_id=?1 and date = ?2", nativeQuery = true)
	List<TrainingSession> findTrainersSessionsByDate(int fk_trainer_id, String date);
	
	@Query(value = "SELECT * FROM tseam_six_3.training_session where fk_client_id=?1 order by date desc", nativeQuery = true)
	List<TrainingSession> findUserSessions(int fk_client_id);
	
	@Query(value = "SELECT * FROM tseam_six_3.training_session where fk_client_id=?1 and date = ?2", nativeQuery = true)
	List<TrainingSession> findUserSessionsBydate(int fk_client_id, String date);

	TrainingSession findById(int id);
}
