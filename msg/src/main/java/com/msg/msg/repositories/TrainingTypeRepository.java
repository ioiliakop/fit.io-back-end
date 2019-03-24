package com.msg.msg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.msg.msg.entities.TrainingType;

public interface TrainingTypeRepository extends JpaRepository<TrainingType, Integer>{

	TrainingType findById(int id);
	
	@Modifying
    @Query(value = "insert into trainer_specialization (fk_trainer_id, fk_training_type) VALUES (:trainerId,:typeId)", nativeQuery = true)
    @Transactional
    void addType(@Param("trainerId") int fk_trainer_id, @Param("typeId") int fk_training_type);
	
	@Modifying
    @Query(value = "delete from trainer_specialization where fk_trainer_id =:trainerId and fk_training_type =:typeId", nativeQuery = true)
    @Transactional
    void removeType(@Param("trainerId") int fk_trainer_id, @Param("typeId") int fk_training_type);
}
