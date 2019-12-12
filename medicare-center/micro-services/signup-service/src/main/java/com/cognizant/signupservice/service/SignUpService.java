package com.cognizant.signupservice.service;

import org.springframework.stereotype.Service;

import com.cognizant.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.signupservice.model.Admin;
import com.cognizant.signupservice.model.Patient;
import com.cognizant.signupservice.model.Doctor;


@Service
public interface SignUpService {
	
	public Admin adminSignUp(Admin admin) throws UserAlreadyExistsException;
	public Patient patientSignup(Patient patient) throws UserAlreadyExistsException;
	public Doctor doctorSignUp(Doctor doctor) throws UserAlreadyExistsException;
	public Patient getSecurityQuestionForPatient(String userName);
	public Admin getSecurityQuestionForAdmin(String userName);
	public Doctor getSecurityQuestionForDoctor(String userName);
	public Doctor updateUserDoctor(Doctor doctor);
	public Admin updateUserAdmin(Admin admin);
	public Patient updateUserPatient(Patient patient);
	
	
}
