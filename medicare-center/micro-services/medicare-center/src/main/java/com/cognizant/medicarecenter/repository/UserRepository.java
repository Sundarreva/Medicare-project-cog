package com.cognizant.medicarecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medicarecenter.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);
}
