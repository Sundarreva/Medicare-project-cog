package com.cognizant.medicarecenter.DTO;

import java.util.Date;

import com.cognizant.medicarecenter.model.Doctor;
import com.cognizant.medicarecenter.model.MedicareService;
import com.cognizant.medicarecenter.model.Patient;

public class RequestDTO {
	
	private int requestId;
	private Patient patient;
	private MedicareService medicareService;
	private Doctor doctor;
	private String approve;
	private Date dateOfAppointment;

	public RequestDTO() {
		super();
	}

	public RequestDTO(int requestId, Patient patient, MedicareService medicareService, Doctor doctor, String approve,
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
