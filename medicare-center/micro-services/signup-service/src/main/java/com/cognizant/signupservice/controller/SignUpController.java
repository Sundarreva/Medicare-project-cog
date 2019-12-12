package com.cognizant.signupservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.signupservice.model.Admin;
import com.cognizant.signupservice.model.Doctor;
import com.cognizant.signupservice.model.Patient;
import com.cognizant.signupservice.service.SignUpService;

@RestController
@RequestMapping("/medicare/signup")
public class SignUpController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);

	@Autowired
	SignUpService signupService;
	
	@GetMapping("/forgetpwd/admin/{userName}")
	public Admin getSecurityQuestionForAdmin(@PathVariable String userName) {
		LOGGER.info("START");
		System.out.println(userName);
		return signupService.getSecurityQuestionForAdmin(userName);
	}
	
	@GetMapping("/forgetpwd/doctor/{userName}")
	public Doctor getSecurityQuestionForDoctor(@PathVariable String userName) {
		LOGGER.info("START");
		return signupService.getSecurityQuestionForDoctor(userName);
	}
	
	@GetMapping("/forgetpwd/patient/{userName}")
	public Patient getSecurityQuestionForPatient(@PathVariable String userName) {
		LOGGER.info("START");
		return signupService.getSecurityQuestionForPatient(userName);
	}
	
	@PutMapping("/update/admin")
	public Admin updateUserAdmin(@RequestBody Admin admin) {
		return signupService.updateUserAdmin(admin);		
	}
	
	@PutMapping("/update/patient")
	public Patient updateUserPatient(@RequestBody Patient patient) {
		return signupService.updateUserPatient(patient);		
	}
	
	@PutMapping("/update/doctor")
	public Doctor updateUserDoctor(@RequestBody Doctor doctor) {
		return signupService.updateUserDoctor(doctor);		
	}

	@PostMapping("/patient")
	public void signup(@RequestBody @Valid Patient patient) throws UserAlreadyExistsException {
		LOGGER.info("START");
		System.out.println(patient);
		signupService.patientSignup(patient);
		LOGGER.info("END");
	}
	
	@PostMapping("/admin")
	public void signup(@RequestBody @Valid Admin admin) throws UserAlreadyExistsException {
		LOGGER.info("START");
		System.out.println(admin);
		signupService.adminSignUp(admin);
		LOGGER.info("END");
	}
	
	@PostMapping("/doctor")
	public void signup(@RequestBody @Valid Doctor doctor) throws UserAlreadyExistsException {
		LOGGER.info("START");
		signupService.doctorSignUp(doctor);
		LOGGER.info("END");
	}
	
}
