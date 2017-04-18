package com.doctorpatient.mvc.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patienthistory")
public class PatientHistory implements Serializable{
	@Id
	@Column(name="duname")
	String duname;
	
	@Column(name="dname")
	String dname;
	@Id
	@Column(name="pname")
	String pname;
	@Id
	@Column(name="notes")
	String notes;
	@Id
	@Column(name = "slotdate", columnDefinition="DATETIME")
	Timestamp slotdate;
	public String getDuname() {
		return duname;
	}
	public void setDuname(String duname) {
		this.duname = duname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Timestamp getSlotdate() {
		return slotdate;
	}
	public void setSlotdate(Timestamp slotdate) {
		this.slotdate = slotdate;
	}
	

	
	

}
