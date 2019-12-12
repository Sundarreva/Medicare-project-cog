package com.cognizant.medicarecenter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicarecenter.repository.AdminRepository;

@Service
public class AdminServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	AdminRepository adminRepository;
	

}
