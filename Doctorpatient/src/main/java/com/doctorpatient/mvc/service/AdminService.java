package com.doctorpatient.mvc.service;

import java.util.List;

import com.doctorpatient.mvc.dao.RegisterDao;
import com.doctorpatient.mvc.model.DoctorRegister;
import com.doctorpatient.mvc.model.DoctorSlots;

public class AdminService {
	
private RegisterDao  regDao=null;
	 
static final long serialVersionUID = 1L;
	
	public RegisterDao getRegDao() {
		return regDao;
	}
	public void setRegDao(RegisterDao regDao) {
		this.regDao = regDao;
	}
	public void saveDoctor(DoctorRegister doctoraddform)
	{
		regDao.saveDoctor(doctoraddform);
	}
	
	public List<DoctorRegister> getDoctorList() {
	
		List<DoctorRegister> data=regDao.getDoctorList();
		return data;
	}
	
	public boolean removeDoctorList(String rduname)
	{
		boolean remove=regDao.removeDoctorList(rduname);
		return remove;
	}
	
	 public List<Object[]>  getDocDetails(String duname) {
		 List<Object[]>  list=regDao.getDocDetails(duname);
		 return list;
	}
	 
	
	



}
