package com.cognizant.medicarecenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.medicarecenter.model.Request;

@Repository
public interface RequestRepository  extends JpaRepository<Request, Integer> {
	
	@Query(nativeQuery=true, value="select * from request where re_approve ='PENDING'")
	List<Request> adminPendingRequest();
	
	@Query(nativeQuery=true, value="select * from request where re_approve='ACCEPTED' and do_id = ?1")
	List<Request> getPendingRequestForDoctor(int id);
	
	@Query(nativeQuery=true, value="select * from request where re_pa_name=?1")
	List<Request> allRequestOfPatient(String patientName);
	
}
