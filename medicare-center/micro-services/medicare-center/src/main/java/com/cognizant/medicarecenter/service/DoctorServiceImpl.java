package com.cognizant.medicarecenter.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.model.MedicareService;
import com.cognizant.medicarecenter.repository.DoctorRepository;
import com.cognizant.medicarecenter.repository.MedicareServiceRepository;

@Service
public class DoctorServiceImpl {
	
private static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	MedicareServiceRepository medicareServiceRepository;
	
	@Transactional
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	@Transactional
	public List<Doctor> getAllDoctorsWithPendingApprovalForAdmin() {
		return doctorRepository.getAllDoctorsWithPendingApprovalForAdmin();
	}
	
	@Transactional
	public List<Doctor> doctorStatusUpdateByAdmin(int id,String status) {
		Doctor doctor = doctorRepository.findById(id).get();
		if(doctor != null) {
			doctor.getUser().setApprovalStatus(status);
			doctorRepository.save(doctor);
			return doctorRepository.getAllDoctorsWithPendingApprovalForAdmin();
		}
		else {
			return null;
		}
	}
	
	@Transactional
	public List<Doctor> getAllApprovedDoctors() {
		return doctorRepository.getAllApprovedDoctors();
	}
	
	@Transactional
	public Doctor addMedicareServiceToDoctor(String userName, int medicareId) {
		LOGGER.info("START");
		Doctor doctor = doctorRepository.findByUserName(userName);
		Set<MedicareService> medicareList = new HashSet<MedicareService>();
		medicareList = doctor.getMedicareList();
		MedicareService medicareService = medicareServiceRepository.findById(medicareId).get();
		medicareList.add(medicareService);
		doctor.setMedicareList(medicareList);
		LOGGER.info("END");
		return doctorRepository.save(doctor);
	}
	
	
	
	@Transactional
	public Doctor getDoctorByName(String userName) {
		LOGGER.info("START");
		return doctorRepository.findByUserName(userName);
	}
	
	
	
}
