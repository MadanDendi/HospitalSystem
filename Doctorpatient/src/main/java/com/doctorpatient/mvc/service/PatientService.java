package com.doctorpatient.mvc.service;

import java.util.List;

import com.doctorpatient.mvc.dao.RegisterDao;
import com.doctorpatient.mvc.model.BookSlot;
import com.doctorpatient.mvc.model.DoctorRegister;
import com.doctorpatient.mvc.model.DoctorSlots;
import com.doctorpatient.mvc.model.OrganDetails;
import com.doctorpatient.mvc.model.PatientHistory;
import com.doctorpatient.mvc.model.PatientRegister;

public class PatientService {
	private RegisterDao  regDao=null;
	static final long serialVersionUID = 1L;
	
	public RegisterDao getRegDao() {
		return regDao;
	}
	public void setRegDao(RegisterDao regDao) {
		this.regDao = regDao;
	}
	
	 public List<DoctorSlots> getDoctorSlots() {
		 List<DoctorSlots> list=regDao.getDoctorSlots();
		 return list;
	 }
	public void savePatient(PatientRegister patientregister)
	{
		regDao.savePatient(patientregister);
	}
	
	
	 public void saveBookSlot(BookSlot bookslot) {
			// TODO Auto-generated method stub
			regDao.saveBookSlot(bookslot);
			
		}
	 
	 public List<PatientHistory> getPatientHistory(String patientID)
	 {
		 return null;
	 }

	 public void saveOrganDetails(OrganDetails organdonorreg)
		{
			regDao.saveOrganDetails(organdonorreg);
		}
	 public List<OrganDetails> getOrganDetails(String organ)
	 {
		List<OrganDetails> organdetails=regDao.getOrganDetails(organ);
		return organdetails;
	 }
}
