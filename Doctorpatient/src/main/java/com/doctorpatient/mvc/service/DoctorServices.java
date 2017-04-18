package com.doctorpatient.mvc.service;

import java.sql.Timestamp;
import java.util.List;

import com.doctorpatient.mvc.dao.RegisterDao;
import com.doctorpatient.mvc.model.BookSlot;
import com.doctorpatient.mvc.model.DoctorSlots;
import com.doctorpatient.mvc.model.PatientHistory;

public class DoctorServices {
	
private RegisterDao  regDao=null;
static final long serialVersionUID = 1L;
	
	
	public RegisterDao getRegDao() {
		return regDao;
	}
	public void setRegDao(RegisterDao regDao) {
		this.regDao = regDao;
	}
	

public void saveDoctorSlot(DoctorSlots doctorslots)
{
	regDao.saveDoctorslot(doctorslots);
}

public List<DoctorSlots> getDoctorSlot(String duname) {

	List<DoctorSlots> doctorslot=regDao.getDoctorSlot(duname);
	return doctorslot;
}

public void dropDoctorslots(String Duname,String Pname,Timestamp slotdate)
{
	
	regDao.dropDoctorslots(Duname, Pname, slotdate);
}
public void savePatientHistory(PatientHistory patienthistory)
{
	 regDao.savePatientHistory(patienthistory);
}
public List<BookSlot> getSlotInfo(String duname)
{
	 List<BookSlot> list=regDao.getSlotInfo(duname);
	 return list;
}


}
