package in.nagendra.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping(value="/welcome",produces="text/plain")
	public ResponseEntity<String> getWelcomeMsg(){
		String msg = "Welcome to Ashok IT";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping(value="/greet",produces="text/plain")
	public String getGreetMsg(){
		return "Welcome to Ashok IT..to..!!!!";
	}
	

	
}
