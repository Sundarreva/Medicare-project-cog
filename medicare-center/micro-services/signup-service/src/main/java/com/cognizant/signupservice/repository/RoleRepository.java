package com.cognizant.signupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.signupservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findById(int id);
	public Role findByName(String name);
}
