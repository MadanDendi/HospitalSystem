package com.doctorpatient.mvc.dao;

import java.sql.Timestamp;
import java.util.List;

import com.doctorpatient.mvc.model.BookSlot;
import com.doctorpatient.mvc.model.DoctorRegister;
import com.doctorpatient.mvc.model.DoctorSlots;
import com.doctorpatient.mvc.model.OrganDetails;
import com.doctorpatient.mvc.model.PatientHistory;
import com.doctorpatient.mvc.model.PatientRegister;

public interface RegisterDao {
	
	public void savePatient(PatientRegister patientregister);
	public void saveDoctor(DoctorRegister doctorregister);
	public List<DoctorRegister> getDoctorList();
	public boolean removeDoctorList(String rduname);
	public void saveDoctorslot(DoctorSlots doctorslot);
	public List<DoctorSlots> getDoctorSlot(String duname);
	public List<Object[]>  getDocDetails(String duname);
	public List<DoctorSlots> getDoctorSlots();
	public void saveBookSlot(BookSlot bookslot);
	public void dropDoctorslots(String Duname,String Pname,Timestamp slotdate);
	public List<BookSlot> getSlotInfo(String duname);
	public void savePatientHistory(PatientHistory patienthistory);
	public List<PatientHistory> getPatientHistory(String patientID);
	public void saveOrganDetails(OrganDetails organdonorreg);
	 public List<OrganDetails> getOrganDetails(String organ);
}
