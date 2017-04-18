package com.doctorpatient.mvc.service;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;


import com.doctorpatient.mvc.dao.RegisterDao;
import com.doctorpatient.mvc.model.BookSlot;
import com.doctorpatient.mvc.model.DoctorRegister;
import com.doctorpatient.mvc.model.DoctorSlots;
import com.doctorpatient.mvc.model.PatientHistory;
import com.doctorpatient.mvc.model.PatientRegister;


public class RegisterService {
	
	private RegisterDao  regDao=null;
	 
	
	
	public RegisterDao getRegDao() {
		return regDao;
	}
	public void setRegDao(RegisterDao regDao) {
		this.regDao = regDao;
	}
	


	
	}


