package in.nagendra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping(
			    value = "/welcome",
			    produces = "text/plain"
			    )
	public String getWelcomeMsg() {

		String msg = "Welcome to REST APIs";

		return msg;
	}

	@GetMapping(
			    value = "/greet",
			    produces = "text/plain"//In which format provider send msg to the consumer
			    )
	public ResponseEntity<String> getGreetMsg() {
		String msg = "Good Morning....!!";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}