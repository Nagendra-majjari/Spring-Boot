package in.nagendra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomMailSender{
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/email")
	@ResponseBody
	public String sendEmail() throws Exception{
		
		SimpleMailMessage msg = new SimpleMailMessage();
		 msg.setFrom("nagendramajjari51@gmail.com");
		msg.setTo("akkupallisiva153@gmail.com");
		msg.setSubject("AshokIT,Software Engineer");
        msg.setText("Thank You for register with ashokIT");
		
		mailSender.send(msg);
		
		return "Email Send Successfully";
	}

}
