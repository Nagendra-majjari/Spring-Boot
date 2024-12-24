package in.nagendra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelRestController {
	
	@GetMapping("/")
	public String MsgRestControler() {
		return "Welcome to AshokIT ";
	}

}
