package com.cognizant.signupservice.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pa_id")
	private int id;

	@Column(name = "pa_user_name", unique = true)
	private String userName;

	@Column(name = "pa_first_name")
	private String firstName;

	@Column(name = "pa_last_name")
	private String lastName;

	@Column(name = "pa_age")
	private int age;

	@Column(name = "pa_gender")
	private String gender;

	@Column(name = "pa_dob")
	private Date dateOfBirth;

	@Column(name = "pa_contact")
	private long contactNumber;

	@Column(name = "pa_alt_contact")
	private long altContactNumber;

	@Column(name = "pa_email")
	private String emailId;

	@Column(name = "pa_password")
	private String password;

	@Column(name = "pa_address_line_1")
	private String addressLineOne;

	@Column(name = "pa_address_line_2")
	private String addressLineTwo;

	@Column(name = "pa_city")
	private String city;

	@Column(name = "pa_state")
	private String state;

	@Column(name = "pa_zip_code")
	private long zipCode;
	
	@Column(name = "pa_security_question")
	private String securityQuestion;
	
	@Column(name = "pa_security_answer")
	private String securityAnswer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "us_id")
	private User user;

	@OneToMany(mappedBy = "patient")
	//@JoinColumn(name = "re_id")
	@JsonIgnoreProperties({"allRequests","patient"})
	private Set<Request> allRequests;

	public Patient() {
		super();
	}

	public Patient(int id, String userName, String firstName, String lastName, int age, String gender, Date dateOfBirth,
			long contactNumber, long altContactNumber, String emailId, String password, String addressLineOne,
			String addressLineTwo, String city, String state, long zipCode, String securityQuestion,
			String securityAnswer, User user, Set<Request> allRequests) {
		super();
		this.id = id;
		this.userName = userName;
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
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.user = user;
		this.allRequests = allRequests;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Request> getAllRequests() {
		return allRequests;
	}

	public void setAllRequests(Set<Request> allRequests) {
		this.allRequests = allRequests;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId + ", password="
				+ password + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", securityQuestion=" + securityQuestion
				+ ", securityAnswer=" + securityAnswer + ", user=" + user + ", allRequests=" + allRequests + "]";
	}	

}