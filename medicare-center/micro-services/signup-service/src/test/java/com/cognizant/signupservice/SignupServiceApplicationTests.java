package com.cognizant.signupservice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
import com.cognizant.signupservice.service.SignUpService;

@SpringBootTest
class SignupServiceApplicationTests {

	@MockBean
	AdminRepository adminRepository;
	
	@MockBean
	DoctorRepository doctorRepository;
	
	@MockBean
	PatientRepository patientRepository;
	
	@MockBean
	UserRepository userRepository;

	@MockBean
	RoleRepository roleRepository;

	@Autowired
	SignUpService signupService;

	@Test
	public void testvoidSignupAdmin() {	
		Admin admin = createAdminWithRole();
		Mockito.when(userRepository.findByUserName(admin.getUserName())).thenReturn(null);
		assertDoesNotThrow(() -> signupService.adminSignUp(admin));	
	}
	
	@Test
	public void testvoidSignupDoctor() {
		Doctor doctor = createDoctorWithRole();
		Mockito.when(userRepository.findByUserName(doctor.getUserName())).thenReturn(null);
		assertDoesNotThrow(() -> signupService.doctorSignUp(doctor));	
	}
	
	@Test
	public void testvoidSignupPatient() {
		Patient patient  = createPatientWithRole();
		Mockito.when(userRepository.findByUserName(patient.getUserName())).thenReturn(null);
		assertDoesNotThrow(() -> signupService.patientSignup(patient));	
	}

	@Test
	public void AdminUserAlreadyExistsException() throws UserAlreadyExistsException {
		Admin admin = createAdminWithRole();
		Mockito.when(adminRepository.findByUserName(admin.getUserName())).thenReturn(admin);
		assertThrows(UserAlreadyExistsException.class, () -> signupService.adminSignUp(admin));
	}
	
	@Test
	public void DoctorUserAlreadyExistsException() throws UserAlreadyExistsException {
		Doctor doctor = createDoctorWithRole();
		Mockito.when(doctorRepository.findByUserName(doctor.getUserName())).thenReturn(doctor);
		assertThrows(UserAlreadyExistsException.class, () -> signupService.doctorSignUp(doctor));
	}
	
	@Test
	public void PatientUserAlreadyExistsException() throws UserAlreadyExistsException {
		Patient patient = createPatientWithRole();
		Mockito.when(patientRepository.findByUserName(patient.getUserName())).thenReturn(patient);
		assertThrows(UserAlreadyExistsException.class, () -> signupService.patientSignup(patient));
	}
	
	@Test
	public void testUpdateUserPatient() {
		Patient patient = createPatientWithRole();
		Mockito.when(patientRepository.findByUserName(patient.getUserName())).thenReturn(patient);
		assertEquals( signupService.updateUserPatient(patient), patient);
	}
	
	@Test
	public void testUpdateUserDoctor() {
		Doctor doctor = createDoctorWithRole();
		Mockito.when(doctorRepository.findByUserName(doctor.getUserName())).thenReturn(doctor);
		assertEquals(signupService.updateUserDoctor(doctor), doctor );
	}
	
	@Test
	public void testUpdateUserAdmin() {
		Admin admin = createAdminWithRole();
		Mockito.when(adminRepository.findByUserName(admin.getUserName())).thenReturn(admin);
		assertEquals(signupService.updateUserAdmin(admin), admin);
	}


	private Admin createAdminWithRole() {

		Admin admin = new Admin();
		admin.setUserName("admin");
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setAge(12);
		admin.setAltContactNumber(215421);
		admin.setContactNumber(234134);
		admin.setDateOfBirth(new Date().toString());
		admin.setEmailId("mailid");
		admin.setGender("Male");
		admin.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");

		User user = new User();
		user.setId(1);
		user.setUserName("test");
		Role role = new Role();
		role.setId(1);
		role.setName("ROLE_ADMIN");
		user.setRole(role);
		user.setApprovalStatus("APPROVED");
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		admin.setUser(user);
		return admin;
	}

	private Doctor createDoctorWithRole() {

		Doctor doctor = new Doctor();
		doctor.setUserName("admin");
		doctor.setFirstName("admin");
		doctor.setLastName("admin");
		doctor.setAge(12);
		doctor.setAltContactNumber(215421);
		doctor.setContactNumber(234134);
		doctor.setDateOfBirth(new Date());
		doctor.setEmailId("mailid");
		doctor.setGender("Male");
		doctor.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		doctor.setAddressLineOne("a");
		doctor.setCity("c");
		doctor.setDegree("BE");
		doctor.setHospitalName("hosptial");
		doctor.setState("state");
		

		User user = new User();
		user.setId(2);
		user.setUserName("test");
		Role role = new Role();
		role.setId(2);
		role.setName("ROLE_DOCTOR");
		user.setRole(role);
		user.setApprovalStatus("APPROVED");
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		doctor.setUser(user);
		return doctor;
	}
	
	private Patient createPatientWithRole() {

		Patient patient = new Patient();
		patient.setUserName("admin");
		patient.setFirstName("admin");
		patient.setLastName("admin");
		patient.setAge(12);
		patient.setAltContactNumber(215421);
		patient.setContactNumber(234134);
		patient.setDateOfBirth(new Date());
		patient.setEmailId("mailid");
		patient.setGender("Male");
		patient.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		patient.setAddressLineOne("a");
		patient.setCity("c");
		patient.setState("state");
		

		User user = new User();
		user.setId(2);
		user.setUserName("test");
		Role role = new Role();
		role.setId(2);
		role.setName("ROLE_DOCTOR");
		user.setRole(role);
		user.setApprovalStatus("APPROVED");
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		patient.setUser(user);
		return patient;
	}


}
