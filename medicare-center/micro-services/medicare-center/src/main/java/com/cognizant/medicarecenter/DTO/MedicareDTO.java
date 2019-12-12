package com.cognizant.medicarecenter.DTO;

import java.util.Set;

public class MedicareDTO {

	private int id;
	private String medicareService;
	private String serviceDescription;
	private long amount;
	private Set<DoctorDTO> doctor;

	public MedicareDTO() {
		super();
	}
	
	public MedicareDTO(int id, String medicareService, String serviceDescription, long amount, Set<DoctorDTO> doctor) {
		super();
		this.id = id;
		this.medicareService = medicareService;
		this.serviceDescription = serviceDescription;
		this.amount = amount;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicareService() {
		return medicareService;
	}

	public void setMedicareService(String medicareService) {
		this.medicareService = medicareService;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Set<DoctorDTO> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<DoctorDTO> doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "MedicareDTO [id=" + id + ", medicareService=" + medicareService + ", serviceDescription="
				+ serviceDescription + ", amount=" + amount + ", doctor=" + doctor + "]";
	}

}
