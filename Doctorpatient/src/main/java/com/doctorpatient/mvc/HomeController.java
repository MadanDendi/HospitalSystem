package com.doctorpatient.mvc;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.criteria.Predicate.BooleanOperator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.joda.time.DateTime;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doctorpatient.mvc.model.BookSlot;
import com.doctorpatient.mvc.model.DoctorRegister;
import com.doctorpatient.mvc.model.DoctorSlots;
import com.doctorpatient.mvc.model.Login;
import com.doctorpatient.mvc.model.OrganDetails;
import com.doctorpatient.mvc.model.PatientHistory;
import com.doctorpatient.mvc.model.PatientRegister;
import com.doctorpatient.mvc.service.AdminService;
import com.doctorpatient.mvc.service.DoctorServices;
import com.doctorpatient.mvc.service.LoginService;
import com.doctorpatient.mvc.service.PatientService;
import com.doctorpatient.mvc.service.RegisterService;







/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	RegisterService regService;
	@Autowired
	LoginService loginService;
	
	@Autowired
	DoctorServices doctorService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	
	AdminService adminService;
	
	static final long serialVersionUID = 1L;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		if(!model.containsAttribute("login")) model.addAttribute("login", new Login());
		return "homepage";
	}
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String HomeCall(Locale locale, Model model) {
		
		if(!model.containsAttribute("login")) model.addAttribute("login", new Login());
		return "homepage";
	}
	
	@RequestMapping(value = "about", method = RequestMethod.POST)
	public String About(Locale locale, Model model) {
		
		return "about";
	}
	
	@RequestMapping(value = "services", method = RequestMethod.POST)
	public String Services(Locale locale, Model model) {
		
		return "services";
	}
	
	@RequestMapping(value = "contact", method = RequestMethod.POST)
	public String Contact(Locale locale, Model model) {
		
		return "contact";
	}
	
	
	@RequestMapping(value = "registeruser")
	public String registerUser(Model model)
	{
	if(!model.containsAttribute("patientadd")) model.addAttribute("patientadd", new PatientRegister());
		//model.addAttribute(messageForm);
	 return "patientreg";	
	}
	
	 @RequestMapping(value = "patientadd", method = RequestMethod.POST)
	  public String send( @Valid @ModelAttribute("patientadd") PatientRegister patientadd, 
		      BindingResult binding, 
		      RedirectAttributes redirectAttributes,Model model){
		 
		 model.addAttribute("success", "");
		 patientadd.setRole("PATIENT");
		 
		 if (binding.hasErrors()) {
		      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageForm", binding);
		      redirectAttributes.addFlashAttribute("patientadd", patientadd);
		      
		      return "patientreg";
		    }
		 try{
		 patientService.savePatient(patientadd); 
	    
		 }
		 catch(Exception ex)
		 {
			 model.addAttribute("exception","Please choose different user name") ;
			 return "patientreg";
		 }
		 model.addAttribute("success", "Succesfully registered "+patientadd.getName());
		 if(!model.containsAttribute("login")) model.addAttribute("login", new Login());
		 return "homepage";
	  }
	 
	
	 @RequestMapping(value = "adddoctor")
		public String addDoctor(Model model)
		{
		if(!model.containsAttribute("doctoraddform")) model.addAttribute("doctoraddform", new DoctorRegister());
			//model.addAttribute(messageForm);
		 return "adddoctors";	
		}
	 
	 @RequestMapping(value = "doctoraddform", method = RequestMethod.POST)
	  public String doctoraddForm( @Valid @ModelAttribute("doctoraddform") DoctorRegister doctoraddform, 
		      BindingResult binding, 
		      RedirectAttributes redirectAttributes,Model model){
		 model.addAttribute("success","");
		 if (binding.hasErrors()) {
		      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageForm", binding);
		      redirectAttributes.addFlashAttribute("doctoraddform", doctoraddform);
		      
		      return "adddoctors";
		    }
		 try{
		 adminService.saveDoctor(doctoraddform);
	    
		 }
		 catch(Exception ex)
		 {
			 model.addAttribute("exception","Please choose different user name") ;
			 return "adddoctors";
		 }
		 model.addAttribute("success","SUCCESSFULLY ADDED "+doctoraddform.getDname());
		 return "adminpage";
	  }
	
	 @RequestMapping(value = "availabilitydoc")
		public String DoctorsAvailable(Model model)
		{
		//if(!model.containsAttribute("patientadd")) model.addAttribute("patientadd", new PatientRegister());
			//model.addAttribute(messageForm);
		 model.addAttribute("success","");
		 List<DoctorRegister> data=adminService.getDoctorList();
		 model.addAttribute("DoctorList", data);
		 return "viewavadoc";	
		}
	 
	 @RequestMapping(value = "removedoctor/{rduname}")
		public String RemoveDoctorList(@PathVariable(value="rduname") String rduname,Model model)
		{
		 //System.out.println("Entered into RemoveDoctorList");
		 model.addAttribute("success","");
		 boolean remove=adminService.removeDoctorList(rduname)	;
		 List<DoctorRegister> data=adminService.getDoctorList();
		 model.addAttribute("DoctorList", data);
		 model.addAttribute("success","SUCCESSFULLY DELETED THE RECORD FOR "+rduname);
		 return "adminpage";
		 
		}
	
	 
	 @RequestMapping(value = "adddoctorslot")
		public String AddDoctorSlot( String duname,Model model,HttpSession session)
		{
		 System.out.println("Duname is :"+session.getAttribute("uname"));
		// if(!model.containsAttribute("adddoctorslotform")) model.addAttribute("adddoctorslotform", new DoctorSlots());
		 
		 return "adddoctorslot";	
		}
	 

	 @RequestMapping(value = "adddoctorslotform", method = RequestMethod.POST)
	  public String doctoraddForm( Model model,HttpSession session,HttpServletRequest request){
		
	 DoctorSlots adddoctorslotform=new DoctorSlots();
		  adddoctorslotform.setDuname(session.getAttribute("uname").toString());
		 List<Object[]> list= adminService.getDocDetails(session.getAttribute("uname").toString());
		 for(Object[] objs:list){	
			   adddoctorslotform.setDuname(objs[0].toString());		
				adddoctorslotform.setDname(objs[2].toString());		
				adddoctorslotform.setSpecialaization(objs[6].toString());
			}
		
		 System.out.println("Selected Date is :"+request.getParameter("slotdate"));
		 
		 
		 // 2016-11-14"+" 21:36"+":00";
		 
		 //String slotdate_str ="2016-11-14"+" 21:36"+":00";
		   String slotdate_str=request.getParameter("slotdate").toString();
		    DateFormat readFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm");
		    DateFormat writeFormat = new SimpleDateFormat( "MM/dd/yyyy HH:mm:sss");
		    Date date = null;
		   
		    try {
		       date = readFormat.parse( slotdate_str );
		    } catch ( Exception e ) {
		        e.printStackTrace();
		    }

		    String formattedDate = "";
		    if( date != null ) {
		    formattedDate = writeFormat.format( date );
		    }

		    try {
				System.out.println(formattedDate);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date slotDate = simpleDateFormat.parse(formattedDate);
				DateTime datetime=new DateTime(slotDate);
				Timestamp aucStarttimeStamp = new Timestamp(datetime.getMillis());
				 System.out.println("DATETIME IS :"+aucStarttimeStamp);
				 adddoctorslotform.setSlotdate(aucStarttimeStamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
			
		 try{
		 doctorService.saveDoctorSlot(adddoctorslotform);
	    
		 }
		 catch(Exception ex)
		 {
			 model.addAttribute("exception","Please choose different user name") ;
			 return "adddoctorslot";
		 }
		 	
		 return "doctorpage";
	  }
	 
	 @RequestMapping(value = "viewdoctorslots")
		public String ViewDoctorSLot(Model model,HttpSession session)
		{
		 List<DoctorSlots> doctorSlotList=doctorService.getDoctorSlot(session.getAttribute("uname").toString());
		 model.addAttribute("doctorSlotList", doctorSlotList);
		 return "viewdoctorslots";
		 
		}
	 
	 
	 @RequestMapping(value = "availabledoclots")
		public String DoctorsAvailablePatient(Model model)
		{
		 List<DoctorSlots> doctorSlotList=patientService.getDoctorSlots();
		 model.addAttribute("doctorSlotList", doctorSlotList);
		 return "availabledoclots";	
		}
	 
	
	 @RequestMapping(value = "bookslot")
		public String bookSlot( @RequestParam Map<String, Object> listparams,Model model,HttpSession session) 
		{
		 //System.out.println("Entered into book slot:"+session.getAttribute("uname").toString());
		 
		 BookSlot bookslot=new BookSlot();
		 bookslot.setPanme(session.getAttribute("uname").toString());
		 for (Map.Entry<String, Object> entry : listparams.entrySet())
		 {
			 try{
		   //  System.out.println("Values are:"+entry.getKey() + "/" + entry.getValue());
			 if(entry.getKey().equals("duname"))
				  bookslot.setDuname(entry.getValue().toString());
			 else if (entry.getKey().equals("dname"))
				 bookslot.setDname(entry.getValue().toString());
			 else if (entry.getKey().equals("specialaization"))
				 bookslot.setSpecialaization(entry.getValue().toString());
			 else if (entry.getKey().equals("slotdate"))
			 {
			
				bookslot.setSlotdate(Timestamp.valueOf(entry.getValue().toString()));
			 }
				 
			 }catch(Exception ie){}
			 
		 }
		 patientService.saveBookSlot(bookslot);
		 doctorService.dropDoctorslots(bookslot.getDuname(),bookslot.getPanme(),bookslot.getSlotdate());
		 
		 return "patientpage";
		}
	 
	 


	 @RequestMapping(value = "addpatienthistory")
		public String addPatientHistory(Model model,HttpSession session)
		{
		 List<BookSlot> slotinfolist=doctorService.getSlotInfo(session.getAttribute("uname").toString());
		 	
		 model.addAttribute("slotinfolist", slotinfolist);
		 if(!model.containsAttribute("patienthistory")) model.addAttribute("patienthistory", new PatientHistory());
		 return "addpatienthistory";
		}
	
	 @RequestMapping(value = "patienthistory")
		public String PatientHistory(@Valid @ModelAttribute("patienthistory") PatientHistory patienthistory, 
			      BindingResult binding, 
			      RedirectAttributes redirectAttributes,Model model,HttpSession session)
		{
		 System.out.println("Entered into PatientHistory");
		 try{
			 System.out.println(patienthistory.getNotes()+patienthistory.getDname());
		 //doctorService.savePatientHistory(patienthistory);
		 }
		 catch(Exception ie)
		 {
			 return "doctorpage";
		 }
		 return "doctorpage";
		}
	 
	
	 
	 @RequestMapping(value = "patientreportsearch")
		public String PatientReport(Model model,HttpSession session)
		{
		 return "patientreportsearch";
		}
	 
	 @RequestMapping(value = "viewpatientreport",method=RequestMethod.POST)
		public String PatientReportForm(@RequestParam String patientID,Model model,HttpSession session)
		{
		// model.addAttribute("PNAME",patientID);
		 
		 return "viewpatientreport";
		}
	 
	 @RequestMapping(value = "registerorgandonor")
		public String registerOrganDonor(Model model,HttpSession session)
		{
		 if(!model.containsAttribute("organdonorreg")) model.addAttribute("organdonorreg", new OrganDetails());
		 return "registerorgandonor";
		}
	 
	 @RequestMapping(value = "organdonorreg",method=RequestMethod.POST)
	 public String organDonorRegForm( @Valid @ModelAttribute("organdonorreg") OrganDetails organdonorreg, 
		      BindingResult binding, 
		      RedirectAttributes redirectAttributes,Model model){
		 
		 try{
		 patientService.saveOrganDetails(organdonorreg);
		 }
		 catch(Exception ie)
		 {
			 if(!model.containsAttribute("login")) model.addAttribute("login", new Login());
			 return "homepage"; 
		 }
		 
		 if(!model.containsAttribute("login")) model.addAttribute("login", new Login());
		 return "homepage";
		 
	 }
		 
	 @RequestMapping(value = "organsearch",method=RequestMethod.GET)
		public String OrganSerach(@RequestParam String organ,Model model,HttpSession session)
		{
		 //System.out.println("ORGAN:"+organ);
		 List<OrganDetails> organdetails=patientService.getOrganDetails(organ);
		 model.addAttribute("organdetails", organdetails);
		 return "vieworgandetails";
		}
	 
	 
		
}
