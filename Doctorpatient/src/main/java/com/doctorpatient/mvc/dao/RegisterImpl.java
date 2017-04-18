package com.doctorpatient.mvc.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.doctorpatient.mvc.model.BookSlot;
import com.doctorpatient.mvc.model.DoctorRegister;
import com.doctorpatient.mvc.model.DoctorSlots;
import com.doctorpatient.mvc.model.OrganDetails;
import com.doctorpatient.mvc.model.PatientHistory;
import com.doctorpatient.mvc.model.PatientRegister;

public class RegisterImpl implements RegisterDao {
	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void savePatient(PatientRegister patientregister) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(patientregister);
		session.getTransaction().commit();
		
		
	}

	@Override
	public void saveDoctor(DoctorRegister doctorregister) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(doctorregister);
		session.getTransaction().commit();
		
	}

	@Override
	public List<DoctorRegister> getDoctorList() {
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select * from doctorregisterdetails");
		
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		
		List<DoctorRegister> doctorlist = new ArrayList<DoctorRegister>();
		for(Object[] objs:list){
			DoctorRegister dItem = new DoctorRegister();
			dItem.setDuname(objs[0].toString());
			dItem.setDpassword(objs[1].toString());
			dItem.setDname(objs[2].toString());
			dItem.setSex(objs[3].toString());
			dItem.setSsn(objs[4].toString());
			dItem.setDsalary(Integer.parseInt(objs[5].toString()));
			dItem.setSpecialaization(objs[6].toString());
			
			doctorlist.add(dItem);
		}
		return doctorlist;

	}

	@Override
	public boolean removeDoctorList(String rduname) {
		
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("delete from doctorregisterdetails where duname = :username");
		query.setParameter("username", rduname);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Hello Deleted record count is :"+result);
		return false;
	}

	@Override
	public void saveDoctorslot(DoctorSlots doctorslot) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(doctorslot);
		session.getTransaction().commit();
		
	}

	@Override
	public List<DoctorSlots> getDoctorSlot(String duname) {
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select * from doctorslots where duname=:duname");
		query.setParameter("duname", duname);
		
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		
		List<DoctorSlots> doctorlist = new ArrayList<DoctorSlots>();
		for(Object[] objs:list){
			DoctorSlots dItem = new DoctorSlots();
			dItem.setDuname(objs[0].toString());
			dItem.setSlotdate(Timestamp.valueOf(objs[1].toString()));
			
			
			doctorlist.add(dItem);
		}
		return doctorlist;
	}

	@Override
	public List<Object[]> getDocDetails(String duname) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		Query query=session.createSQLQuery("select * from doctorregisterdetails where duname=:duname");
		query.setParameter("duname", duname);
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		return list;
		
		
	}

	@Override
	public List<DoctorSlots> getDoctorSlots() {
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select * from doctorslots ");
		
		
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		
		List<DoctorSlots> doctorslot = new ArrayList<DoctorSlots>();
		for(Object[] objs:list){
			DoctorSlots dItem = new DoctorSlots();
			dItem.setDuname(objs[0].toString());
			dItem.setSlotdate(Timestamp.valueOf(objs[1].toString()));
			dItem.setDname(objs[2].toString());
			dItem.setSpecialaization(objs[3].toString());
			System.out.println("Values :"+objs[0].toString()+" "+(java.util.Date)objs[1]+" "+objs[2].toString()+" "+objs[3].toString());
			doctorslot.add(dItem);
		}
		return doctorslot;
	}

	@Override
	public void saveBookSlot(BookSlot bookslot) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(bookslot);
		session.getTransaction().commit();
		
	}

	@Override
	public void dropDoctorslots(String Duname, String Pname, Timestamp slotdate) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("delete from doctorslots where duname = :duname and slotdate=:slotdate");
		query.setParameter("duname", Duname);
		query.setParameter("slotdate", slotdate);
		int result = query.executeUpdate();
		session.getTransaction().commit();
	}
	@Override
	public List<BookSlot> getSlotInfo(String duname)
	{
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select * from bookslot where duname=:duname ");
		query.setParameter("duname", duname);	
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		
		List<BookSlot> bookslotinfo = new ArrayList<BookSlot>();
		for(Object[] objs:list){
			BookSlot dItem = new BookSlot();
			dItem.setDuname(objs[0].toString());
			dItem.setDname(objs[1].toString());
			dItem.setPanme(objs[2].toString());
			dItem.setSpecialaization(objs[3].toString());
			dItem.setSlotdate(Timestamp.valueOf(objs[4].toString()));
			bookslotinfo.add(dItem);
		}
		return bookslotinfo;

	}

	
	public void savePatientHistory(PatientHistory patienthistory) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(patienthistory);
		session.getTransaction().commit();
		
	}

	public List<PatientHistory> getPatientHistory(String patientID)
	{
		

		Session session = sessionFactory.openSession();

		/*// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select * from bookslot where duname=:duname ");
		query.setParameter("duname", duname);	
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		
		List<BookSlot> bookslotinfo = new ArrayList<BookSlot>();
		for(Object[] objs:list){
			BookSlot dItem = new BookSlot();
			dItem.setDuname(objs[0].toString());
			dItem.setDname(objs[1].toString());
			dItem.setPanme(objs[2].toString());
			dItem.setSpecialaization(objs[3].toString());
			dItem.setSlotdate(Timestamp.valueOf(objs[4].toString()));
			bookslotinfo.add(dItem);
		}
		return bookslotinfo;*/

		return null;
	}

	
	public void saveOrganDetails(OrganDetails organdonorreg)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(organdonorreg);
		session.getTransaction().commit();
	}
	
	 public List<OrganDetails> getOrganDetails(String organ)
	 {
		 Session session = sessionFactory.openSession();

			Transaction tx = session.beginTransaction();
			org.hibernate.Query query = session.createSQLQuery("select * from organdetails where organ LIKE :organ  ");
			query.setParameter("organ","%"+organ+"%");	
			Map<String,Object> row = null;
			List<Object[]> list = query.list();
			
			List<OrganDetails> organdetails = new ArrayList<OrganDetails>();
			for(Object[] objs:list){
				OrganDetails dItem = new OrganDetails();
				dItem.setOname(objs[0].toString());
				System.out.println("DONOR:"+objs[0].toString());
				dItem.setSex(objs[1].toString());
				dItem.setMobile(Integer.parseInt(objs[2].toString()));
				dItem.setEmail(objs[3].toString());
				dItem.setOrgan(objs[4].toString());
				dItem.setBloodgroup(objs[5].toString());
				organdetails.add(dItem);
			}
			return organdetails;

	 }
	

	
	
}
