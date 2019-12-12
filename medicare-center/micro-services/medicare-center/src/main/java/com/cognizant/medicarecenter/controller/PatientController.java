package com.cognizant.medicarecenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicarecenter.DTO.PatientDTO;
import com.cognizant.medicarecenter.model.Patient;
import com.cognizant.medicarecenter.service.PatientServiceImpl;

@RestController
@RequestMapping("/medicare")
public class PatientController {

	@Autowired
	PatientServiceImpl patientServiceImpl;

	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return patientServiceImpl.getAllPatients();
	}

	@GetMapping("/patients/{userName}")
	public Patient getPatientByName(@PathVariable String userName) {
		return patientServiceImpl.getPatientByName(userName);
	}

	@GetMapping("/patients/requests")
	public List<Patient> getPatientListForAdminApproval() {
		return patientServiceImpl.getAllPatientsWithPendingApprovalForAdmin();
	}

	@PutMapping("/patients/{id}/{status}")
	public List<Patient> patientStatusUpdatedByAdmin(@PathVariable int id, @PathVariable String status) {
		return patientServiceImpl.patientStatusUpdatedByAdmin(id, status);
	}

	private PatientDTO[] transformPatientToDTO(List<Patient> patientList) {
		PatientDTO[] patientDTO = new PatientDTO[patientList.size()];
		int count = 0;
		for (Patient patient : patientList) {
			patientDTO[count] = new PatientDTO();
			patientDTO[count].setId(patient.getId());
			patientDTO[count].setFirstName(patient.getFirstName());
			patientDTO[count].setLastName(patient.getLastName());
			patientDTO[count].setAge(patient.getAge());
			patientDTO[count].setDateOfBirth(patient.getDateOfBirth());
			patientDTO[count].setGender(patient.getGender());
			patientDTO[count].setUsername(patient.getUserName());
			patientDTO[count].setContactNumber(patient.getContactNumber());
			patientDTO[count].setAltContactNumber(patient.getAltContactNumber());
			patientDTO[count].setEmailId(patient.getEmailId());
			patientDTO[count].setPassword(patient.getPassword());
			patientDTO[count].setAddressLineOne(patient.getAddressLineOne());
			patientDTO[count].setAddressLineTwo(patient.getAddressLineTwo());
			patientDTO[count].setCity(patient.getCity());
			patientDTO[count].setState(patient.getState());
			patientDTO[count].setZipcode(patient.getZipCode());
			//patientList.add(patientDTO[count]);
			count++;
		}
		return patientDTO;
	}

}
