package in.nagendra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoMsgController {
	
	@GetMapping("/demo")
	public ResponseEntity<String> getDemoMsg(){
		
		int i = 10/0;
		
		String msg ="Hi this is Demo msg send by me";
		
		return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
