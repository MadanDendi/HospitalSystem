package com.doctorpatient.mvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Table
@Entity(name="patientregisterdetails")
public class PatientRegister implements Serializable {
	
	/*@Id
	@Column(name="p_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int p_id;
	*/
	@Id
	@Column(name="puname")
	@NotBlank(message = "Please provide your user name")
	@Size(min=3,max=20,message="Size should be in between 3 and 20")
	String puname;
	@Id
	@Column(name="ppassword")
	@NotBlank(message = "Please provide password")
	@Size(min=3,max=20,message="Size should be in between 3 and 20")
	String ppassword;
	@Column(name="name")
	@NotBlank(message = "Please provide your name")
	@Size(min=3,max=20,message="Size should be in between 3 and 20")
	String name;
	@Column(name="sex")
	@NotBlank(message = "Select your Sex")
	String sex;
	//@Column(name="joiningDate")
	//Date joiningDate;
	@Column(name="ssn",unique=true, nullable=false)
	@NotBlank(message = "Enter your SSN")
	String ssn;
	
	@Column(name="role")
	String role;
	
	/*public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}*/
	public String getPuname() {
		return puname;
	}
	public void setPuname(String puname) {
		this.puname = puname;
	}
	public String getPpassword() {
		return ppassword;
	}
	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	/*public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}*/
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
