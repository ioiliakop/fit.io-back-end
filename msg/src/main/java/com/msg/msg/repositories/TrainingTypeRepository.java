package com.msg.msg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msg.msg.entities.TrainingType;

public interface TrainingTypeRepository extends JpaRepository<TrainingType, Integer>{

	TrainingType findById(int id);
}
