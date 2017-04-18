package com.doctorpatient.mvc.service;

import com.doctorpatient.mvc.dao.LoginDao;

public class LoginService {
	private LoginDao logindao;
	static final long serialVersionUID = 1L;
	public LoginDao getLogindao() {
		return logindao;
	}
	public void setLogindao(LoginDao logindao) {
		this.logindao = logindao;
	}
	public String isValidUser(String username,String password)
	{
		String valid=logindao.isValidUser(username, password);
		return valid;
	}

}
