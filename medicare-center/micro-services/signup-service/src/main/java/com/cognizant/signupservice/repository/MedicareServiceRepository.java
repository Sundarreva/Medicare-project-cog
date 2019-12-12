package com.cognizant.signupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.signupservice.model.MedicareService;

@Repository
public interface MedicareServiceRepository extends JpaRepository<MedicareService,Integer> {
	
	@Query(nativeQuery = true,value ="select * from medicare_service where ms_id = :id")
	public MedicareService getById(@Param("id")int id);

}
