package in.nagendra.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nagendra.exception.ExInfo;

@RestController
public class MsgCotroller {

	@GetMapping("/welcome")
	public String welcomeMsgController() {
		
		String s = null;
		s.length(); // NPE
		
		
		String msg = "Hi every one,this is nagendra....";
		return msg;
	}

	@GetMapping("/greet")
	public ResponseEntity<String> greetMsg() {

		int i = 10 / 0;

		String msg = "Hi all, Good Morning to All......";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	/*
	 * @ExceptionHandler(value = Exception.class) 
	 * public ResponseEntity<String> handleException(Exception e) {
	 * 
	 * String message = e.getMessage();
	 * 
	 * return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	// Handling class local exception
	
//	@ExceptionHandler(value = Exception.class)
//	public ResponseEntity<ExInfo> handleException(Exception e) {
//
//		String message = e.getMessage();
//
//		ExInfo ex = new ExInfo();
//
//		ex.setExCode("EX809879");
//		ex.setExMsg(message);
//		ex.setDate(LocalDateTime.now());
//
//		return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}
	



}
