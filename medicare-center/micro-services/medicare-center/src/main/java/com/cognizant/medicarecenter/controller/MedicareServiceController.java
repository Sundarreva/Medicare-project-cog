package com.cognizant.medicarecenter.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicarecenter.DTO.DoctorDTO;
import com.cognizant.medicarecenter.DTO.MedicareDTO;
import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.model.MedicareService;
import com.cognizant.medicarecenter.service.MedicareServiceServiceImpl;


@RestController
@RequestMapping("/medicare")
public class MedicareServiceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MedicareServiceController.class);
	
	@Autowired
	MedicareServiceServiceImpl medicareServiceServiceImpl;
	
	@GetMapping("/medicare_services")
	public MedicareDTO[] getAllMedicareServices() {
		return transformMedicareToDTO(medicareServiceServiceImpl.getAllMedicareServices());
	}
	
	@GetMapping("/medicare_services/notselected/{userName}")
	public List<MedicareService> getUnselectedMedicareServicesForDoctor(@PathVariable String userName) {
		return medicareServiceServiceImpl.getUnselectedMedicareServicesForDoctor(userName);
	}
	
	@PostMapping("/medicare_services")
	public boolean addAnMedicareService(@RequestBody MedicareService newService) {
		return medicareServiceServiceImpl.addAnMedicareService(newService);
	}

	
	@GetMapping("/medicare_services/{id}")
	public MedicareDTO getMedicareById(@PathVariable int id) {
		return transformMedicareToDTO(medicareServiceServiceImpl.getMedicareById(id));
		
	}
	
	private MedicareDTO[] transformMedicareToDTO(List<MedicareService> medicareServices) {
		MedicareDTO[] medicareDTO = new MedicareDTO[medicareServices.size()];
		int count = 0;
		for (MedicareService medicareService : medicareServices) {
			medicareDTO[count] = new MedicareDTO();		
			medicareDTO[count].setId(medicareService.getId());
			medicareDTO[count].setMedicareService(medicareService.getMedicareService());
			medicareDTO[count].setServiceDescription(medicareService.getServiceDescription());
			medicareDTO[count].setAmount(medicareService.getAmount());
			
			Set<Doctor> doctorList = medicareService.getDoctor();
			Set<DoctorDTO> doctorListDto = new HashSet<DoctorDTO>();
			for (Doctor doctor : doctorList) {
				DoctorDTO doctorDTO = new DoctorDTO();	
				doctorDTO.setId(doctor.getId());
				doctorDTO.setUsername(doctor.getUserName());
				doctorDTO.setFirstname(doctor.getFirstName());
				doctorDTO.setLastname(doctor.getLastName());
				doctorDTO.setAge(doctor.getAge());
				doctorDTO.setGender(doctor.getGender());
				doctorDTO.setDateOfBirth(doctor.getDateOfBirth());
				doctorDTO.setContactNumber(doctor.getContactNumber());
				doctorDTO.setAltContactNumber(doctor.getAltContactNumber());
				doctorDTO.setEmailId(doctor.getEmailId());
				doctorDTO.setPassword(doctor.getPassword());
				doctorDTO.setAddressLineOne(doctor.getAddressLineOne());
				doctorDTO.setAddressLineTwo(doctor.getAddressLineTwo());
				doctorDTO.setCity(doctor.getCity());
				doctorDTO.setState(doctor.getState());
				doctorDTO.setZipCode(doctor.getZipCode());
				doctorDTO.setDegree(doctor.getDegree());
				doctorDTO.setSpeciality(doctor.getSpeciality());
				doctorDTO.setWorkHours(doctor.getWorkHours());
				doctorDTO.setHospitalName(doctor.getHospitalName());
				doctorListDto.add(doctorDTO);
			}
			medicareDTO[count].setDoctor(doctorListDto);
			count++;
		}
		return medicareDTO;
	}
	
	
	private MedicareDTO transformMedicareToDTO(MedicareService medicare) {
		MedicareDTO medicareDTO = new MedicareDTO();
		medicareDTO.setId(medicare.getId());
		medicareDTO.setMedicareService(medicare.getMedicareService());
		medicareDTO.setServiceDescription(medicare.getServiceDescription());
		medicareDTO.setAmount(medicare.getAmount());
		Set<Doctor> doctorList = medicare.getDoctor();
		Set<DoctorDTO> doctorListDto = new HashSet<DoctorDTO>();
		for (Doctor doc : doctorList) {
			DoctorDTO doctorDTO = new DoctorDTO();
			doctorDTO.setId(doc.getId());
			doctorDTO.setUsername(doc.getUserName());
			doctorDTO.setFirstname(doc.getFirstName());
			doctorDTO.setLastname(doc.getLastName());
			doctorDTO.setAge(doc.getAge());
			doctorDTO.setGender(doc.getGender());
			doctorDTO.setDateOfBirth(doc.getDateOfBirth());
			doctorDTO.setContactNumber(doc.getContactNumber());
			doctorDTO.setAltContactNumber(doc.getAltContactNumber());
			doctorDTO.setEmailId(doc.getEmailId());
			doctorDTO.setPassword(doc.getPassword());
			doctorDTO.setAddressLineOne(doc.getAddressLineOne());
			doctorDTO.setAddressLineTwo(doc.getAddressLineTwo());
			doctorDTO.setCity(doc.getCity());
			doctorDTO.setState(doc.getState());
			doctorDTO.setZipCode(doc.getZipCode());
			doctorDTO.setDegree(doc.getDegree());
			doctorDTO.setSpeciality(doc.getSpeciality());
			doctorDTO.setWorkHours(doc.getWorkHours());
			doctorDTO.setHospitalName(doc.getHospitalName());
			doctorListDto.add(doctorDTO);
		}
		medicareDTO.setDoctor(doctorListDto);
		return medicareDTO;
	}
	
	
	
	
	

}
