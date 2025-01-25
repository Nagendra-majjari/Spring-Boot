package in.nagendra.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class msgRestController {
	

	@GetMapping("/contact")
	public String contact() {
		return "91+ 90 14 64 81 25";
	}
	
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome to Ashok IT";
	}
	
	@GetMapping("/greet")
	public String greetMsg() {
		return "Good Morning to All";
	}
}
