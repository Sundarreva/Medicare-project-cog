package com.cognizant.medicarecenter.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicarecenter.exception.UserRegistrationException;
import com.cognizant.medicarecenter.model.User;
import com.cognizant.medicarecenter.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/medicare")
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) throws UserRegistrationException {
		LOGGER.info("START");
		Map<String, String> data = new HashMap<>();
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		User userData = userRepository.findByUserName(user);
		
		if(userData.getApprovalStatus().equals("PENDING")) {
			throw new UserRegistrationException("Your Request is Pending");		
		} else if(userData.getApprovalStatus().equals("REJECTED")) {
			throw new UserRegistrationException("Your Request is Rejected");
		}
		
		data.put("token", generateJwt(getUser(authHeader)));
		data.put("role", role);
		data.put("user", user);
		LOGGER.info("END");
		return data;
	}

	private String getUser(String authHeader) {
		LOGGER.info("START");
		String encodedCredentials = authHeader.split(" ")[1];
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		LOGGER.info("END");
		return decodedCredentials.split(":")[0];
	}

	private String generateJwt(String user) {
		LOGGER.info("START");
		LOGGER.debug("GENEARTE JWT");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		LOGGER.info("END");
		return token;
	}
}