package com.doctorpatient.mvc.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LoginImpl implements LoginDao {

	private SessionFactory sessionFactory;
	String role;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public String isValidUser(String username, String password) {
		
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select * from login_details where username = :username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		Map<String,Object> row = null;
		List<Object[]> data = query.list();
		for(Object[] obj:data){
			
			System.out.println((obj[0].toString()));
			System.out.println((obj[1].toString()));
			role=obj[2].toString();
			System.out.println(role);
			 
		}
		if(!data.isEmpty())
			return role;
		
		else
			return "MADAN";
		
				
	}

}
