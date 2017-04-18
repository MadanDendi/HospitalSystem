package com.doctorpatient.mvc;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doctorpatient.mvc.model.Login;
import com.doctorpatient.mvc.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "login")
	public String LoginUser(@ModelAttribute("login")Login login,Model model,HttpSession session)
	{
	 String  role=loginService.isValidUser(login.getUsername(), login.getPassword());
	// System.out.println("ROLE is :"+role);
	 if(role.equals("ADMIN"))
	 {
		 session.setAttribute("uname", login.getUsername());
		 return "adminpage";
	 }
	 else if (role.equals("PATIENT"))
	 {
		 session.setAttribute("uname", login.getUsername());
		 System.out.println("In LOgin:"+session.getAttribute("uname").toString());
		 return "patientpage";
	 }
		 
	 else if (role.equals("DOCTOR"))
	 {
		 
		// model.addAttribute("duname", login.getUsername());
		 
		 session.setAttribute("uname", login.getUsername());
		 System.out.println("In LOgin:"+session.getAttribute("uname").toString());
		 return "doctorpage";
	 }
	
	 
	 if(!model.containsAttribute("login")) model.addAttribute("login", new Login());
		return "homepage";
	 
	 
	}

	 @RequestMapping(value = "logout", method = RequestMethod.GET)
		public String logOut( Model model,HttpSession session) {
		 session.removeAttribute("uname");
		 if(!model.containsAttribute("login")) model.addAttribute("login", new Login());
			return "homepage";
			
		 
		}


		
}
