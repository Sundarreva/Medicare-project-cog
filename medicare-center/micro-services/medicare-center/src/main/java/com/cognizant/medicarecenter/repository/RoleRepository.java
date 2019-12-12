package com.cognizant.medicarecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.medicarecenter.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findById(int id);
	public Role findByName(String name);
}
