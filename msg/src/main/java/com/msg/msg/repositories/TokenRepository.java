package com.msg.msg.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msg.msg.entities.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {

	@Query(value = "select iduser from token where alphanumeric=?", nativeQuery = true)
	int getUserIDFromTokenAlphaNumeric(String alphanumeric);

	
}
