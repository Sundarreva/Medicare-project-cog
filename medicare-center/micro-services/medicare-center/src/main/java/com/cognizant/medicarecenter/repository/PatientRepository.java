package com.cognizant.medicarecenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.medicarecenter.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public Patient findByUserName(String username);
	
	@Query("Select p from Patient p join p.user u join u.role r where r.name = 'ROLE_PATIENT' and u.approvalStatus like 'PENDING'")
	public List<Patient> getAllPatientsWithPendingApprovalForAdmin();
	
}
