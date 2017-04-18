package com.doctorpatient.mvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="doctorregisterdetails")
public class DoctorRegister implements Serializable{
	

	@Id
	@Column(name="duname")
	@NotBlank(message = "Please provide your user name")
	@Size(min=3,max=20,message="Size should be in between 3 and 20")
	String duname;
	@Id
	@Column(name="dpassword")
	@NotBlank(message = "Please provide password")
	@Size(min=3,max=20,message="Size should be in between 3 and 20")
	String dpassword;
	@Column(name="dname")
	@NotBlank(message = "Please provide your name")
	@Size(min=3,max=20,message="Size should be in between 3 and 20")
	String dname;
	@Column(name="sex")
	@NotBlank(message = "Select your Sex")
	String sex;
	//@Column(name="joiningDate")
	//Date joiningDate;
	@Column(name="ssn",unique=true, nullable=false)
	@NotBlank(message = "Enter your SSN")
	String ssn;
	
	@Column(name="dsalary")
	int dsalary;
	
	
	@Column(name="specialaization")
	String specialaization;

	@Column(name="role")
	String role;

	

	public String getDuname() {
		return duname;
	}


	public void setDuname(String duname) {
		this.duname = duname;
	}


	public String getDpassword() {
		return dpassword;
	}


	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public int getDsalary() {
		return dsalary;
	}


	public void setDsalary(int dsalary) {
		this.dsalary = dsalary;
	}


	public String getSpecialaization() {
		return specialaization;
	}


	public void setSpecialaization(String specialaization) {
		this.specialaization = specialaization;
	}
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	
	
}
