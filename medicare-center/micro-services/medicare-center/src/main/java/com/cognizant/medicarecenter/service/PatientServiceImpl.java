package com.cognizant.medicarecenter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicarecenter.model.Patient;
import com.cognizant.medicarecenter.repository.PatientRepository;

@Service
public class PatientServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	PatientRepository patientRepository;
	
	@Transactional
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	
	@Transactional
	public Patient getPatientById(int id) {
		return patientRepository.findById(id).get();
	}
	
	@Transactional
	public Patient getPatientByName(String userName) {
		return patientRepository.findByUserName(userName);
	}
	
	@Transactional
	public List<Patient> getAllPatientsWithPendingApprovalForAdmin() {
		return patientRepository.getAllPatientsWithPendingApprovalForAdmin();
	}

	@Transactional
	public List<Patient> patientStatusUpdatedByAdmin(int id, String status) {
		Patient patient = patientRepository.findById(id).get();
		if (patient != null) {
			patient.getUser().setApprovalStatus(status);
			patientRepository.save(patient);
			return patientRepository.findAll();
		} else {
			return null;
		}
	}

}
