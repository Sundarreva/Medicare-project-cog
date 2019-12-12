package com.cognizant.signupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.signupservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);
}
