package com.cognizant.medicarecenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@NotNull
	@Size(min = 2, max = 10, message = "Username should be between 2 to 10 charecters")
	@Column(name = "us_name")
	private String userName;

	@NotNull
	@Column(name = "us_password")
	private String password;
	
	@Column(name = "us_approval_status")
	private String approvalStatus;

	@ManyToOne
	@JoinColumn(name = "ro_id")
	private Role role;

	public User() {
		super();
	}

	public User(int id,
			@NotNull @Size(min = 2, max = 10, message = "Username should be between 2 to 10 charecters") String userName,
			@NotNull String password, String approvalStatus, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.approvalStatus = approvalStatus;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", approvalStatus="
				+ approvalStatus + ", role=" + role + "]";
	}
	
}