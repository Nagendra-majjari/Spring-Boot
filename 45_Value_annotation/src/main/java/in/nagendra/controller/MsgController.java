package in.nagendra.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nagendra.proper.AppProperties;

@RestController
public class MsgController {

	@Value("${message}")
	private String message;

	@Autowired
	private AppProperties proper;
	
	@GetMapping("/")
	public String greetMessage() {
		return message;
	}

	@GetMapping("/greet")
	public String greetMsg() {

		Map<String, String> message = proper.getMsg();

		return message.get("greet_msg");

	}
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		
		Map<String, String> msg = proper.getMsg();
		
		return msg.get("welcome_msg");
		
	}
	
	

}
























