package com.msg.msg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.msg.msg.entities.Token;
import com.msg.msg.entities.User;

public interface TokenRepository extends JpaRepository<Token, Integer> {

	List<Token> findByUser(User user);

	@Modifying
	@Query(value = "insert into token (alphanumeric, iduser) values (:alphanumeric , :iduser)", nativeQuery = true)
	void insertToken(@Param("alphanumeric") String alphanumeric, @Param("iduser") int iduser);
}
