package com.doctorpatient.mvc.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="bookslot")
public class BookSlot implements Serializable{
	
	@Id
	@Column(name="duname")
	String duname;
	
	@Column(name="dname")
	String dname;
	@Id
	@Column(name="pname")
	String panme;
	@Id
	@Column(name="specialaization")
	String specialaization;
	
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
	public String getPanme() {
		return panme;
	}
	public void setPanme(String panme) {
		this.panme = panme;
	}
	public String getSpecialaization() {
		return specialaization;
	}
	public void setSpecialaization(String specialaization) {
		this.specialaization = specialaization;
	}

	public Timestamp getSlotdate() {
		return slotdate;
	}
	public void setSlotdate(Timestamp slotdate) {
		this.slotdate = slotdate;
	}

}
