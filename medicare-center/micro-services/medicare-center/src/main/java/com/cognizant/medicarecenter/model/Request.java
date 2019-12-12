package com.cognizant.medicarecenter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "request")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "re_id")
	private int requestId;
	
	@ManyToOne
	@JoinColumn(name = "pa_id")
	@JsonIgnoreProperties("allRequests")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "ms_id")
	@JsonIgnoreProperties({"allRequests","doctor"})
	private MedicareService medicareService;
	
	@ManyToOne
	@JoinColumn(name = "do_id")
	@JsonIgnoreProperties("medicareList")
	private Doctor doctor;
	
	@Column(name = "re_approve")
	private String approve;
	
	@Column(name = "re_date")
	private Date dateOfAppointment;

 
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Request(int requestId, Patient patient, MedicareService medicareService, Doctor doctor, String approve,
			Date dateOfAppointment) {
		super();
		this.requestId = requestId;
		this.patient = patient;
		this.medicareService = medicareService;
		this.doctor = doctor;
		this.approve = approve;
		this.dateOfAppointment = dateOfAppointment;
	}


	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public MedicareService getMedicareService() {
		return medicareService;
	}


	public void setMedicareService(MedicareService medicareService) {
		this.medicareService = medicareService;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public String getApprove() {
		return approve;
	}


	public void setApprove(String approve) {
		this.approve = approve;
	}


	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}


	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}


	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", patient=" + patient + ", medicareService=" + medicareService
				+ ", doctor=" + doctor + ", approve=" + approve + ", dateOfAppointment=" + dateOfAppointment + "]";
	}
	
}
