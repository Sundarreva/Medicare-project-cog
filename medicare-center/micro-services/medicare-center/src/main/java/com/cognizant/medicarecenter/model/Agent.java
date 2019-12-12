package com.cognizant.medicarecenter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ag_id")
	private int id;
	
	@Column(name = "ag_first_name")
	private String firstName;
	
	@Column(name = "ag_last_name")
	private String lastName;
	
	@Column(name = "ag_age")
	private String age;
	
	@Column(name = "ag_gender")
	private String gender;
	
	@Column(name = "ag_date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "ag_contact_number")
	private long contactNumber;
	
	@Column(name = "ag_alt_contact_number")
	private long altContactNumber;
	
	@Column(name = "ag_emailid")
	private String emailId;
	
	@Column(name = "ag_password")
	private String password;
	
	@Column(name = "ag_address_line_1")
	private String addressLineOne;
	
	@Column(name = "ag_address_line_2")
	private String addressLineTwo;
	
	@Column(name = "ag_city")
	private String city;
	
	@Column(name = "ag_state")
	private String state;
	
	@Column(name = "ag_zip_code")
	private String zipCode;

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(int id, String firstName, String lastName, String age, String gender, Date dateOfBirth,
			long contactNumber, long altContactNumber, String emailId, String password, String addressLineOne,
			String addressLineTwo, String city, String state, String zipCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.altContactNumber = altContactNumber;
		this.emailId = emailId;
		this.password = password;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAltContactNumber() {
		return altContactNumber;
	}

	public void setAltContactNumber(long altContactNumber) {
		this.altContactNumber = altContactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber=" + contactNumber + ", altContactNumber="
				+ altContactNumber + ", emailId=" + emailId + ", password=" + password + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
	
}
