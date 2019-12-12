package com.cognizant.medicarecenter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.medicarecenter.exception.UserAlreadyExistsException;
import com.cognizant.medicarecenter.model.Admin;
import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.model.Role;
import com.cognizant.medicarecenter.model.User;
import com.cognizant.medicarecenter.repository.AdminRepository;
import com.cognizant.medicarecenter.repository.DoctorRepository;
import com.cognizant.medicarecenter.repository.PatientRepository;
import com.cognizant.medicarecenter.repository.RoleRepository;
import com.cognizant.medicarecenter.repository.UserRepository;
import com.cognizant.medicarecenter.service.SignUpService;

@SpringBootTest
public class UserDetailsServiceTest {

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
	public void testvoidSignupUser() {	
		Admin admin = createAdminWithRole();
		Mockito.when(userRepository.findByUserName(admin.getUserName())).thenReturn(null);
		assertDoesNotThrow(() -> signupService.adminSignUp(admin));	
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

//	@Test
//	public void testLoadByUserName() throws UserAlreadyExistsException {
//
//		when(userRepository.findByUserName("user")).thenReturn(null);
//		when(userRepository.save(createUserWithRole())).thenReturn(createUserWithRole());
//		
//		SignUpService.signup(createUserWithOutRole());
//		assertEquals("USER",createUserWithRole().getUserRoleList().iterator().next().getName());
//	}

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
	
	private Doctor createPatientWithRole() {

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

//	private User createUserWithRole() {
//		User user = new User();
//		user.setId(2);
//		user.setFirstName("user");
//		user.setLastName("user");
//		user.setUserName("user");
//		Set<Role> roleList = new HashSet();
//		Role role = new Role();
//		role.setId(1);
//		role.setName("USER");
//		roleList.add(role);
//		user.setUserRoleList(roleList);
//		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
//		return user;
//	}

}
