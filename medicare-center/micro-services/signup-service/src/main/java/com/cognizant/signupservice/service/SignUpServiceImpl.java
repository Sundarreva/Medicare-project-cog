package com.cognizant.signupservice.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.signupservice.exception.UserAlreadyExistsException;
import com.cognizant.signupservice.model.Admin;
import com.cognizant.signupservice.model.Doctor;
import com.cognizant.signupservice.model.Patient;
import com.cognizant.signupservice.model.Role;
import com.cognizant.signupservice.model.User;
import com.cognizant.signupservice.repository.AdminRepository;
import com.cognizant.signupservice.repository.DoctorRepository;
import com.cognizant.signupservice.repository.PatientRepository;
import com.cognizant.signupservice.repository.RoleRepository;
import com.cognizant.signupservice.repository.UserRepository;



@Service
public class SignUpServiceImpl implements SignUpService {
		
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpServiceImpl.class);

	@Transactional
	public Patient patientSignup(Patient patient) throws UserAlreadyExistsException {
		LOGGER.info("START");
		if ((patientRepository.findByUserName(patient.getUserName()) == null) 
				&& (userRepository.findByUserName(patient.getUserName()) == null)) {
			LOGGER.debug("NEW PATIENT SIGNUP");
			System.out.println(patient);
			Patient newPatient = new Patient();
			newPatient.setAddressLineOne(patient.getAddressLineOne());
			newPatient.setAddressLineTwo(patient.getAddressLineTwo());
			newPatient.setAge(patient.getAge());
			newPatient.setAltContactNumber(patient.getAltContactNumber());
			newPatient.setCity(patient.getCity());
			newPatient.setContactNumber(patient.getContactNumber());
			newPatient.setDateOfBirth(patient.getDateOfBirth());
			newPatient.setEmailId(patient.getEmailId());
			newPatient.setFirstName(patient.getFirstName());
			newPatient.setGender(patient.getGender());
			newPatient.setId(patient.getId());
			newPatient.setLastName(patient.getLastName());
			newPatient.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
			newPatient.setState(patient.getState());
			newPatient.setUserName(patient.getUserName());
			newPatient.setZipCode(patient.getZipCode());
			newPatient.setSecurityQuestion(patient.getSecurityQuestion());
			newPatient.setSecurityAnswer(patient.getSecurityAnswer());
			User newUser = new User();
			newUser.setUserName(patient.getUserName());
			newUser.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
			newUser.setApprovalStatus("PENDING");
			Role role = roleRepository.findByName("ROLE_PATIENT");
			newUser.setRole(role);
			newPatient.setUser(newUser);
			LOGGER.debug("NEW PATIENT DETAILS: {}", newPatient);
			LOGGER.info("END");
			return patientRepository.save(newPatient);
		} else {
			LOGGER.debug("USER ALREADY EXIST EXCEPTION");
			throw new UserAlreadyExistsException("User already Exist");
		}
	}

	@Transactional
	public Admin adminSignUp(Admin admin) throws UserAlreadyExistsException  {
		LOGGER.info("START");
		if ((adminRepository.findByUserName(admin.getUserName()) == null)
				&& (userRepository.findByUserName(admin.getUserName()) == null)) {
			LOGGER.debug("NEW ADMIN SIGNUP");
			System.out.println(admin);
			Admin newAdmin = new Admin();
			newAdmin.setAge(admin.getAge());
			newAdmin.setAltContactNumber(admin.getAltContactNumber());
			newAdmin.setContactNumber(admin.getContactNumber());
			newAdmin.setDateOfBirth(admin.getDateOfBirth());
			newAdmin.setEmailId(admin.getEmailId());
			newAdmin.setFirstName(admin.getFirstName());
			newAdmin.setGender(admin.getGender());
			newAdmin.setId(admin.getId());
			newAdmin.setLastName(admin.getLastName());
			newAdmin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
			newAdmin.setUserName(admin.getUserName());
			newAdmin.setSecurityQuestion(admin.getSecurityQuestion());
			newAdmin.setSecurityAnswer(admin.getSecurityAnswer());
			User newUser = new User();
			newUser.setUserName(admin.getUserName());
			newUser.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
			newUser.setApprovalStatus("APPROVED");
			Role role = roleRepository.findByName("ROLE_ADMIN");
			newUser.setRole(role);
			newAdmin.setUser(newUser);
			LOGGER.debug("NEW ADMIN DETAILS: {}", newAdmin);
			LOGGER.info("END");
			return adminRepository.save(newAdmin);
		} else {
			LOGGER.debug("USER ALREADY EXIST EXCEPTION");
			throw new UserAlreadyExistsException("User already Exist");
		}
	}

	@Transactional
	public Doctor doctorSignUp(Doctor doctor) throws UserAlreadyExistsException {
		LOGGER.info("START");
		if ((doctorRepository.findByUserName(doctor.getUserName()) == null)
				&& (userRepository.findByUserName(doctor.getUserName()) == null)) {
			LOGGER.debug("NEW DOCTOR SIGNUP");
			System.out.println(doctor);
			Doctor newDoctor = new Doctor();
			newDoctor.setAddressLineOne(doctor.getAddressLineOne());
			newDoctor.setAddressLineTwo(doctor.getAddressLineTwo());
			newDoctor.setAge(doctor.getAge());
			newDoctor.setAltContactNumber(doctor.getAltContactNumber());
			newDoctor.setCity(doctor.getCity());
			newDoctor.setContactNumber(doctor.getContactNumber());
			newDoctor.setDateOfBirth(doctor.getDateOfBirth());
			newDoctor.setDegree(doctor.getDegree());
			newDoctor.setEmailId(doctor.getEmailId());
			newDoctor.setFirstName(doctor.getFirstName());
			newDoctor.setGender(doctor.getGender());
			newDoctor.setHospitalName(doctor.getHospitalName());
			newDoctor.setLastName(doctor.getLastName());
			newDoctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
			newDoctor.setSpeciality(doctor.getSpeciality());
			newDoctor.setState(doctor.getState());
			newDoctor.setUserName(doctor.getUserName());
			newDoctor.setWorkHours(doctor.getWorkHours());
			newDoctor.setZipCode(doctor.getZipCode());
			newDoctor.setSecurityQuestion(doctor.getSecurityQuestion());
			newDoctor.setSecurityAnswer(doctor.getSecurityAnswer());
			User newUser = new User();
			newUser.setUserName(doctor.getUserName());
			newUser.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
			newUser.setApprovalStatus("PENDING");
			Role role = roleRepository.findByName("ROLE_DOCTOR");
			newUser.setRole(role);
			newDoctor.setUser(newUser);
			userRepository.save(newUser);
			LOGGER.debug("NEW DOCTOR DETAILS: {}", newDoctor);
			LOGGER.info("END");
			return doctorRepository.save(newDoctor);
		} else {
			LOGGER.debug("USER ALREADY EXIST EXCEPTION");
			throw new UserAlreadyExistsException("User already Exist");
		}
	}

	@Override
	public Patient getSecurityQuestionForPatient(String userName) {
		return patientRepository.findByUserName(userName);
	}

	@Override
	public Admin getSecurityQuestionForAdmin(String userName) {
		return adminRepository.findByUserName(userName);
	}

	@Override
	public Doctor getSecurityQuestionForDoctor(String userName) {
		return doctorRepository.findByUserName(userName);		
	}

	@Override
	public Doctor updateUserDoctor(Doctor doctor) {
		Doctor existDoc = doctorRepository.findByUserName(doctor.getUserName());
		existDoc.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
		User user = existDoc.getUser();
		user.setPassword(existDoc.getPassword());
		return doctorRepository.save(existDoc);
	}

	@Override
	public Admin updateUserAdmin(Admin admin) {
		Admin existAdm = adminRepository.findByUserName(admin.getUserName());
		existAdm.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
		User user = existAdm.getUser();
		user.setPassword(existAdm.getPassword());
		return adminRepository.save(existAdm);
	}

	@Override
	public Patient updateUserPatient(Patient patient) {
		Patient existPat = patientRepository.findByUserName(patient.getUserName());
		existPat.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
		User user = existPat.getUser();
		user.setPassword(existPat.getPassword());
		return patientRepository.save(existPat);
	}
}
