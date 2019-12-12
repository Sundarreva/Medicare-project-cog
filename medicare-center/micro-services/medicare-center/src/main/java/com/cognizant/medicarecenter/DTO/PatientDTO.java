package com.cognizant.medicarecenter.DTO;

import java.util.Date;
import java.util.Set;

import com.cognizant.medicarecenter.model.Request;
import com.cognizant.medicarecenter.model.User;

public class PatientDTO {

	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private Date dateOfBirth;
	private long contactNumber;
	private long altContactNumber;
	private String emailId;
	private String password;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String state;
	private long zipcode;
	private User user;
	private Set<Request> allRequests;

	public PatientDTO(int id, String username, String firstName, String lastName, int age, String gender,
			Date dateOfBirth, long contactNumber, long altContactNumber, String emailId, String password,
			String addressLineOne, String addressLineTwo, String city, String state, long zipcode, User user,
			Set<Request> allRequests) {
		super();
		this.id = id;
		this.username = username;
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
		this.zipcode = zipcode;
		this.user = user;
		this.allRequests = allRequests;
	}

	public PatientDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public long getZipcode() {
		return zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
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
		return "PatientDTO [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId + ", password="
				+ password + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + ", user=" + user + ", allRequests=" + allRequests
				+ "]";
	}

}
