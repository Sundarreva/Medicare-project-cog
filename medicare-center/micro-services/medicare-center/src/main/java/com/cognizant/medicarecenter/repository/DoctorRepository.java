package com.cognizant.medicarecenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.medicarecenter.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	public Doctor findByUserName(String userName);
	
	@Query("Select d from Doctor d join d.user u join u.role r where r.name = 'ROLE_DOCTOR' and u.approvalStatus like 'PENDING'")
	public List<Doctor> getAllDoctorsWithPendingApprovalForAdmin();
	
	@Query("Select d from Doctor d join d.user u join u.role r where r.name = 'ROLE_DOCTOR' and u.approvalStatus like 'ACCEPTED'")
	public List<Doctor> getAllApprovedDoctors();
}
