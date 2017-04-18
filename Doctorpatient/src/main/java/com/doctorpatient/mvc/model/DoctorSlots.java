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
@Entity
@Table(name="doctorslots")
public class DoctorSlots implements Serializable {
@Id
@Column(name="duname")
String duname;

@Id
@Column(name = "slotdate", columnDefinition="DATETIME")

Timestamp slotdate;

@Column(name="dname")
String dname;

@Column(name="specialaization")
String specialaization;

public String getDuname() {
	return duname;
}
public void setDuname(String duname) {
	this.duname = duname;
}



public Timestamp getSlotdate() {
	return slotdate;
}
public void setSlotdate(Timestamp slotdate) {
	this.slotdate = slotdate;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getSpecialaization() {
	return specialaization;
}
public void setSpecialaization(String specialaization) {
	this.specialaization = specialaization;
}

}
