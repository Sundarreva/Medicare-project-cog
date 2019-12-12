package com.cognizant.medicarecenter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicarecenter.DTO.DoctorDTO;
import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.service.DoctorServiceImpl;
import com.cognizant.medicarecenter.service.RequestServiceImpl;

@RestController
@RequestMapping("/medicare")
public class DoctorController {
	
	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	@Autowired
	private RequestServiceImpl requestServiceImpl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors() {
		LOGGER.info("START");
		return 	doctorServiceImpl.getAllDoctors();
	}
	
	@GetMapping("/doctors/{userName}")
	public Doctor getDoctorByName(@PathVariable String userName) {
		System.out.println(userName);
		return doctorServiceImpl.getDoctorByName(userName);
	}
	
	
	@GetMapping("/doctors/requests")
	public List<Doctor> getDoctorListForAdminApproval() {
		LOGGER.info("START");
		return 	doctorServiceImpl.getAllDoctorsWithPendingApprovalForAdmin();
	}
	
	@PutMapping("doctors/service/{docName}/{id}")
	public Doctor addMedicareServiceToDoctor(@PathVariable String docName,@PathVariable int id) {
		LOGGER.info("START");
		return doctorServiceImpl.addMedicareServiceToDoctor(docName,id);
	}
	
	@GetMapping("/doctors/accepts")
	public List<Doctor> getAllApprovedDoctors() {
		LOGGER.info("START");
		return 	doctorServiceImpl.getAllApprovedDoctors();
	}
	
	@PutMapping("/doctors/{id}/{status}")
	public List<Doctor> doctorStatusUpdatedByAdmin(@PathVariable int id, @PathVariable String status) {
		LOGGER.info("START");
		 return doctorServiceImpl.doctorStatusUpdateByAdmin(id, status);
	}
	
	

	
	
//	@GetMapping("/doctors/doctorViewRequest")
//	public List<Request> doctorPendingRequest(){
//		LOGGER.info("START");
//		return requestServiceImpl.doctorPendingRequest();	
//	}
//	
//	@PostMapping("/doctors/{userName}/{medicareServiceId}")
//	public Doctor addMedicareServiceToDoctor(@PathVariable String userName, @PathVariable int medicareServiceId) {
//		LOGGER.info("START");
//		return doctorServiceImpl.addMedicareServiceToDoctor(userName, medicareServiceId);
//	}
	
	
	
	
	
	
	private DoctorDTO[] transformDoctorToDTO(List<Doctor> doctorList) {
		DoctorDTO[] doctorDTO = new DoctorDTO[doctorList.size()];
		int count = 0;
		for (Doctor doctor : doctorList) {	
				doctorDTO[count].setId(doctor.getId());
				doctorDTO[count].setUsername(doctor.getUserName());
				doctorDTO[count].setFirstname(doctor.getFirstName());
				doctorDTO[count].setLastname(doctor.getLastName());
				doctorDTO[count].setAge(doctor.getAge());
				doctorDTO[count].setGender(doctor.getGender());
				doctorDTO[count].setDateOfBirth(doctor.getDateOfBirth());
				doctorDTO[count].setContactNumber(doctor.getContactNumber());
				doctorDTO[count].setAltContactNumber(doctor.getAltContactNumber());
				doctorDTO[count].setEmailId(doctor.getEmailId());
				doctorDTO[count].setPassword(doctor.getPassword());
				doctorDTO[count].setAddressLineOne(doctor.getAddressLineOne());
				doctorDTO[count].setAddressLineTwo(doctor.getAddressLineTwo());
				doctorDTO[count].setCity(doctor.getCity());
				doctorDTO[count].setState(doctor.getState());
				doctorDTO[count].setZipCode(doctor.getZipCode());
				doctorDTO[count].setDegree(doctor.getDegree());
				doctorDTO[count].setSpeciality(doctor.getSpeciality());
				doctorDTO[count].setWorkHours(doctor.getWorkHours());
				doctorDTO[count].setHospitalName(doctor.getHospitalName());
				count++;
			}		
			return doctorDTO;
		}
		
	}
	

	
	
