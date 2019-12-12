package com.cognizant.medicarecenter.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("START");
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		LOGGER.info("END");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("START");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		LOGGER.info("START");
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
		.antMatchers("/medicare/signup/patient").anonymous().antMatchers("/medicare/signup/doctor").anonymous()
		.antMatchers("/medicare/signup/admin").anonymous().anyRequest().authenticated().and()
		.addFilter(new JwtAuthorizationFilter(authenticationManager()));

//		.authorizeRequests()
//		.antMatchers("/medicare").permitAll()
//		.antMatchers("/medicare/sign-up/patient").anonymous()
//		.anyRequest().authenticated();
		LOGGER.info("END");
	}

}