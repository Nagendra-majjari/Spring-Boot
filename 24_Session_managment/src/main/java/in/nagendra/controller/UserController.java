package in.nagendra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.nagendra.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		User userObj = new User();
		model.addAttribute("user",userObj);
		
		return "index";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req,Model model) {
		
		User userObj = new User();
		model.addAttribute("user",userObj);
		
		HttpSession session = req.getSession(false);
		session.invalidate();  //removing the session
		return "index";
		
	}
	
	/*
	 * @PostMapping("/login") public String login(User user,Model model) { String
	 * email = user.getEmail(); String password = user.getPassword();
	 * 
	 * if(email.equals("nagendra@gmail.com")&& password.equals("abc@123")){ //valid
	 * login
	 * 
	 * return "dashboard";
	 * 
	 * }else {
	 * 
	 * //invalid login model.addAttribute("emsg", "Invalid Credentials");
	 * 
	 * }
	 * 
	 * return "index";
	 * 
	 * }
	 */
	
	@GetMapping("/person-details")
	@ResponseBody
	public String getPersonalData( HttpServletRequest req,Model model) {
		
		HttpSession session = req.getSession(false);//false means get the existing session
		
		Object email = (String) session.getAttribute("email");
		//get the Personal data based on email
		return "Getting Personal Details of    "+ email;
	}
	
	@GetMapping("/edu-details")
	@ResponseBody
	public String getEduData( HttpServletRequest req,Model model) {
		
		HttpSession session = req.getSession(false);//false means get the existing session
		
		Object email = (String) session.getAttribute("email");
		//get the Educational data based on email
		return "Getting Educational Details of    "+ email;
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req ,User user,Model model) {
		String email = user.getEmail();
		String password = user.getPassword();
	    
	    if(email.equals("nagendra@gmail.com")&&
	                 password.equals("abc@123")){
	    	//valid login
	    	
	    	HttpSession session = req.getSession(true);// If we use true then always new session will be created 
	    	session.setAttribute("email", email);
	    	return "dashboard";
	    	
	    }else {
	    	
	    	//invalid login
	    	model.addAttribute("emsg", "Invalid Credentials");
	    	
	    }
	    
	   return "index"; 
		
	}

}









