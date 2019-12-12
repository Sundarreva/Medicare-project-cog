package com.cognizant.medicarecenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.model.MedicareService;
import com.cognizant.medicarecenter.repository.DoctorRepository;
import com.cognizant.medicarecenter.repository.MedicareServiceRepository;


@Service
public class MedicareServiceServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(MedicareServiceServiceImpl.class);

	@Autowired
	MedicareServiceRepository medicareRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Transactional
	public List<MedicareService> getAllMedicareServices() {
		return medicareRepository.findAll();
	}

	@Transactional
	public List<MedicareService> getUnselectedMedicareServicesForDoctor(String userName) {
		LOGGER.info("START");
//		List<MedicareService> medicareList = medicareRepository.findAll();
//		Doctor doctor = doctorRepository.findByUserName(userName);
//		//List <MedicareService> listNotAvailable = new ArrayList<MedicareService>();
//		for(MedicareService allService : medicareList) {
//			for(MedicareService service : doctor.getMedicareList()) {
//				if(allService.getId() == service.getId()) {
//					medicareList.remove(allService);
//				}
//			}
//		}
//		return medicareList;
		List<MedicareService> unaddedServices = new ArrayList<MedicareService>();
		Doctor doctor = doctorRepository.findByUserName(userName);
		Set<MedicareService> doctorServices = doctor.getMedicareList();
		List<MedicareService> allMedicareServices = medicareRepository.findAll();
		for(MedicareService medicare: allMedicareServices) {
			int flag = 0;
			for(MedicareService doctorService : doctorServices) {
				if(medicare.getId() == doctorService.getId()) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				unaddedServices.add(medicare);	
			}
		}
		return unaddedServices;
	}

	@Transactional
	public boolean addAnMedicareService(MedicareService newService) {
		medicareRepository.save(newService);
		return true;
	}

	@Transactional
	public MedicareService getMedicareById(int id) {
		return medicareRepository.getById(id);
	}

}
