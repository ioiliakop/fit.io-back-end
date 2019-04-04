package com.msg.msg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.msg.msg.entities.Area;
import com.msg.msg.entities.TrainingType;
import com.msg.msg.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	@Query(value = "SELECT user.iduser, user.username,user.password,user.fk_role_id, user.first_name,user.last_name,user.email,user.price,user.description\r\n"
//			+ ",user.photo_link, user.is_active,user.random_num FROM user, trainer_area,  trainer_specialization, area ,training_type\r\n"
//			+ "WHERE user.iduser=trainer_specialization.fk_trainer_id AND user.iduser=trainer_area.fk_trainer_id AND \r\n"
//			+ "training_type.idtraining_type=trainer_specialization.fk_training_type AND area.idarea=trainer_area.fk_area_id\r\n"
//			+ "AND training_type.specialization_title= ?1 AND area.city= ?2", nativeQuery = true)
	
	List<User> findByTrainerAreasAndTrainerTypes(Area area, TrainingType trainingType);

	@Query(value = "SELECT user.iduser,user.username,user.password,user.fk_role_id,user.first_name,user.last_name,user.email,user.price,user.description,user.photo_link,user.is_active,user.random_num"
			+ " FROM user,training_type,trainer_specialization,trainer_area,area"
			+ " WHERE user.iduser=trainer_specialization.fk_trainer_id AND trainer_specialization.fk_training_type = training_type.idtraining_type AND "
			+ "user.iduser=trainer_area.fk_trainer_id AND trainer_area.fk_area_id=area.idarea AND specialization_title = ?1 AND"
			+ " city= ?2 AND price <=?3", nativeQuery = true)
	List<User> findTrainerByAreaAndTypeAndPrice(int idarea, int idtraining_type, double price);

//	@Query(value = "SELECT user.iduser,user.username,user.password,user.fk_role_id,user.first_name,user.last_name,user.email,user.price,user.description,user.photo_link,user.is_active,user.random_num"
//			+ " FROM user,trainer_area,area WHERE iduser=fk_trainer_id AND fk_area_id=idarea AND idarea=?1", nativeQuery = true)
	
	List<User> findByTrainerAreas(Area area);

	@Query(value = "SELECT user.iduser,user.username,user.password,user.fk_role_id,user.first_name,user.last_name,user.email,user.price,user.description,user.photo_link,user.is_active,user.random_num"
			+ " FROM user,trainer_area,area WHERE iduser=fk_trainer_id AND fk_area_id=idarea AND idarea=?1 and price <=?2", nativeQuery = true)
	List<User> findTrainerByAreaAndPrice(int idarea, double price);

//	@Query(value = "SELECT user.iduser,user.username,user.password,user.fk_role_id,user.first_name,user.last_name,user.email,user.price,user.description,user.photo_link,user.is_active,user.random_num"
//			+ " FROM user,trainer_specialization,training_type WHERE iduser=fk_trainer_id AND fk_training_type=idtraining_type AND idtraining_type =?1", nativeQuery = true)
	List<User> findByTrainerTypes(TrainingType trainingType);

	@Query(value = "SELECT user.iduser,user.username,user.password,user.fk_role_id,user.first_name,user.last_name,user.email,user.price,user.description,user.photo_link,user.is_active,user.random_num "
			+ "FROM user,trainer_specialization,training_type WHERE iduser=fk_trainer_id AND fk_training_type=idtraining_type AND idtraining_type =?1 AND price <=?2", nativeQuery = true)
	List<User> findTrainerByTypeAndPrice(int idtraining_type, double price);

	@Query(value = "SELECT * FROM user WHERE price > 0.0 AND price <= ?1", nativeQuery = true)
	List<User> findTrainerByPrice(double price);

	User findById(int id);

	User findByUsername(String username);
	
	User findByEmail(String email);

	User findByUsernameAndPassword(String username, String password);
	

}
