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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "do_id")
	private int id;
	
	@Column(name = "do_user_name", unique = true)
	private String userName;
	
	@Column(name = "do_first_name")
	private String firstName;
	
	@Column(name = "do_last_name")
	private String lastName;
	
	@Column(name = "do_age")
	private int age;
	
	@Column(name = "do_gender")
	private String gender;
	
	@Column(name = "do_date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "do_contact_number")
	private long contactNumber;
	
	@Column(name = "do_alt_contact_number")
	private long altContactNumber;
	
	@Column(name = "do_email_id")
	private String emailId;
	
	@Column(name = "do_password")
	private String password;
	
	@Column(name = "do_address_line_1")
	private String addressLineOne;
	
	@Column(name = "do_address_line_2")
	private String addressLineTwo;
	
	@Column(name = "do_city")
	private String city;
	
	@Column(name = "do_state")
	private String state;
	
	@Column(name = "do_zip_code")
	private long zipCode;
	
	@Column(name = "do_degree")
	private String degree;
	
	@Column(name = "do_speciality")
	private String speciality;
	
	@Column(name = "do_work_hours")
	private String workHours;
	
	@Column(name = "do_hospital_name")
	private String hospitalName;
	
	@Column(name = "do_security_question")
	private String securityQuestion;
	
	@Column(name = "do_security_answer")
	private String securityAnswer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "us_id")
	private User user;
	
	@ManyToMany()
	@JoinTable(name = "doctor_medicare_service",
				joinColumns = @JoinColumn(name = "dm_do_id"),
				inverseJoinColumns = @JoinColumn(name = "dm_ms_id"))
	@JsonIgnoreProperties("doctor")
	private Set<MedicareService> medicareList;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int id, String userName, String firstName, String lastName, int age, String gender, Date dateOfBirth,
			long contactNumber, long altContactNumber, String emailId, String password, String addressLineOne,
			String addressLineTwo, String city, String state, long zipCode, String degree, String speciality,
			String workHours, String hospitalName, String securityQuestion, String securityAnswer, User user,
			Set<MedicareService> medicareList) {
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
		this.degree = degree;
		this.speciality = speciality;
		this.workHours = workHours;
		this.hospitalName = hospitalName;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.user = user;
		this.medicareList = medicareList;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<MedicareService> getMedicareList() {
		return medicareList;
	}

	public void setMedicareList(Set<MedicareService> medicareList) {
		this.medicareList = medicareList;
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

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + ", altContactNumber=" + altContactNumber + ", emailId=" + emailId + ", password="
				+ password + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", degree=" + degree + ", speciality="
				+ speciality + ", workHours=" + workHours + ", hospitalName=" + hospitalName + ", securityQuestion="
				+ securityQuestion + ", securityAnswer=" + securityAnswer + ", user=" + user + ", medicareList="
				+ medicareList + "]";
	}


	
}
