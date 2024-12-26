package in.nagendra.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.internet.MimeMessage;

@Controller
public class CustomMailSender{
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/")
	@ResponseBody
	public String sendEmail() throws Exception{
		
		/*
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("nagendramajjari51@gmail.com");
		msg.setTo("nagendramajjari51@gmail.com");
		msg.setSubject("AshokIT,Software Engineer");
        msg.setText("Thank You for register with ashokIT");
		
		mailSender.send(msg);
		
		return "Email Send Successfully";
		*/
		
		
		MimeMessage msg = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(msg,true);
		
		helper.setFrom("nagendramajjari51@gmail.com");
		helper.setTo("nagendramajjari51@gmail.com");
		helper.setSubject("Welcome to Ashokit");
		helper.setText("<h1>Welcome to Ashokit</h1><p>Thank you for joining our platform!</p>", true);
				
		helper.addAttachment("ProjectTemplate.jpg", new File("C:/Users/nagen/OneDrive/Pictures/Java Real-time Project template(1).jpg"));
		helper.addAttachment("NatureImage.jpg", new File("C:/Users/nagen/OneDrive/Pictures/natureimage.jpg"));

		helper.addAttachment("DEVOPS-AWS.pdf", new File("C:/Users/nagen/OneDrive/Desktop/Documents/DEVOPS-AWS.pdf"));
		
		mailSender.send(msg);
		
		return "Mail has been sent successfully!";
	}

}
