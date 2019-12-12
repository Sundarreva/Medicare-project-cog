package com.cognizant.medicarecenter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.model.Request;
import com.cognizant.medicarecenter.repository.DoctorRepository;
import com.cognizant.medicarecenter.repository.RequestRepository;

@Service
public class RequestServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestServiceImpl.class);

	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Transactional
	public List<Request> getAllRequests() {
		LOGGER.info("START");
		return requestRepository.findAll();
	}
	
	@Transactional
	public List<Request> getServiceRequests() {
		LOGGER.info("START");
		return requestRepository.adminPendingRequest();
	}
	
	@Transactional
	public Request saveAnRequest(Request request) {
		LOGGER.info("START");
		return requestRepository.save(request);
	}
	
	@Transactional
	public List<Request> getPendingRequestForDoctor(String docName) {
		LOGGER.info("START");
		Doctor doctor = doctorRepository.findByUserName(docName);
		return requestRepository.getPendingRequestForDoctor(doctor.getId());		
	}

	@Transactional
	public List<Request> requestStatusUpdatedByAdmin(int id, String status) {
		LOGGER.info("START");
		Request request = requestRepository.findById(id).get();
		if (request != null) {
			request.setApprove(status);
			requestRepository.save(request);
			return requestRepository.findAll();
		} else 
			return null;
		
	}
	
	@Transactional
	public List<Request> requestStatusUpdatedByDoctor(int id, String status, String name) {
		LOGGER.info("START");
		Request request = requestRepository.findById(id).get();
		if (request != null) {
			request.setApprove(status);
			requestRepository.save(request);
			Doctor doctor = doctorRepository.findByUserName(name);
			int doc_id = doctor.getId();
			return requestRepository.getPendingRequestForDoctor(doc_id);
		} else 
			return null;
		
	}

}
