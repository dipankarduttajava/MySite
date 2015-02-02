package com.tekdtel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekdtel.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	User findByName(String name);
	
	
}
