package com.cognizant.medicarecenter.controller;

import java.util.List;

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

import com.cognizant.medicarecenter.model.Request;
import com.cognizant.medicarecenter.service.RequestServiceImpl;

@RestController
@RequestMapping("/medicare")
public class RequestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestController.class);
	
	@Autowired
	private RequestServiceImpl requestServiceImpl;
	
	@GetMapping("/requests")
	public List<Request> getAllRequest() {
		LOGGER.info("START"); 
		return requestServiceImpl.getAllRequests();
	}
	
	@PostMapping("/request")
	public Request saveAnRequest(@RequestBody Request request) {
		LOGGER.info("START");
		return requestServiceImpl.saveAnRequest(request);
	}
	
	@GetMapping("/requests/pendings")
	public List<Request> getsServiceRequests() {
		LOGGER.info("START");
		return requestServiceImpl.getServiceRequests();
	}
	
	@GetMapping("/requests/doctors/pendings/{docName}")
	public List<Request> getPendingRequestForDoctor(@PathVariable String docName) {
		LOGGER.info("START");
		return requestServiceImpl.getPendingRequestForDoctor(docName);
	}
	
	@PutMapping("/requests/{id}/{status}")
	public List<Request> requestStatusUpdatedByAdmin(@PathVariable int id, @PathVariable String status) {
		return requestServiceImpl.requestStatusUpdatedByAdmin(id,status);		
	}
	
	@PutMapping("/requests/{id}/{status}/{name}")
	public List<Request> requestStatusUpdatedByDoctor(@PathVariable int id, @PathVariable String status, @PathVariable String name) {
		return requestServiceImpl.requestStatusUpdatedByDoctor(id,status,name);		
	}
	
	
	
//	@GetMapping("/doctors/requests/{requestId}")
//	public Request getOneRequest(@PathVariable int requestId) {
//		LOGGER.info("START");
//		return requestServiceImpl.getOneRequest(requestId);
//	}
//	
	

}
