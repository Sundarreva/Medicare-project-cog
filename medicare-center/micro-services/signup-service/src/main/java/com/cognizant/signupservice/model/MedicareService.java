package com.cognizant.signupservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medicare_service")
public class MedicareService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ms_id")
	private int id;
	
	@Column(name = "ms_medicare_service")
	private String medicareService;
	
	@Column(name = "ms_Service_description")
	private String serviceDescription;
	
	@Column(name = "ms_amount")
	private long amount;
	
	@ManyToMany(mappedBy = "medicareList")
	private Set<Doctor> doctor;
	
	@OneToMany
	@JoinColumn(name = "re_id")
	private Set<Request> allRequests;

	public MedicareService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicareService(int id, String medicareService, String serviceDescription, long amount, Set<Doctor> doctor,
			Set<Request> allRequests) {
		super();
		this.id = id;
		this.medicareService = medicareService;
		this.serviceDescription = serviceDescription;
		this.amount = amount;
		this.doctor = doctor;
		this.allRequests = allRequests;
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

	public Set<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<Doctor> doctor) {
		this.doctor = doctor;
	}

	public Set<Request> getAllRequests() {
		return allRequests;
	}

	public void setAllRequests(Set<Request> allRequests) {
		this.allRequests = allRequests;
	}

	@Override
	public String toString() {
		return "MedicareService [id=" + id + ", medicareService=" + medicareService + ", serviceDescription="
				+ serviceDescription + ", amount=" + amount + ", doctor=" + doctor + ", allRequests=" + allRequests
				+ "]";
	}
	
	
	
}
