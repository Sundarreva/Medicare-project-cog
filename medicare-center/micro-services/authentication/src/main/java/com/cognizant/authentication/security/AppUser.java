package com.cognizant.authentication.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.authentication.model.Role;
import com.cognizant.authentication.model.User;


public class AppUser implements UserDetails {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUser.class);

	private static final long serialVersionUID = 1L;
	private User user;
	private Collection<? extends GrantedAuthority> authorities;

	public AppUser(User user) {
		LOGGER.info("START");
		List<Role> role = new ArrayList<Role>();
		role.add(user.getRole());
		this.user = user;
		this.authorities = role.stream().map(currentRole -> new SimpleGrantedAuthority(currentRole.getName()))
				.collect(Collectors.toList());
		LOGGER.info("END");
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		LOGGER.info("START");
		return this.authorities;
	}

	@Override
	public String getPassword() {
		LOGGER.info("START");
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		LOGGER.info("START");
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		LOGGER.info("START");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		LOGGER.info("START");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		LOGGER.info("START");
		return true;
	}

	@Override
	public boolean isEnabled() {
		LOGGER.info("START");
		return true;
	}
}