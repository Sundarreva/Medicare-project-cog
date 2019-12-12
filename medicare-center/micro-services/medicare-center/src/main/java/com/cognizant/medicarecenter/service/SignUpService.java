package com.cognizant.medicarecenter.service;

import org.springframework.stereotype.Service;

import com.cognizant.medicarecenter.exception.UserAlreadyExistsException;
import com.cognizant.medicarecenter.model.Admin;
import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.model.Patient;

@Service
public interface SignUpService {
	
	public Admin adminSignUp(Admin admin) throws UserAlreadyExistsException;
	public Patient patientSignup(Patient patient) throws UserAlreadyExistsException;
	public Doctor doctorSignUp(Doctor doctor) throws UserAlreadyExistsException;
	
	
}
