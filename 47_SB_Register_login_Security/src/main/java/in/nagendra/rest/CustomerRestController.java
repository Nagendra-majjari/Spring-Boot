package in.nagendra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nagendra.entity.Customer;
import in.nagendra.repo.CustomerRepository;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private PasswordEncoder pwdEncoder;

	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody Customer customer) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(customer.getEmail(),
				customer.getPwd());

		
			Authentication authenticate = authManager.authenticate(token);
			
			if (authenticate.isAuthenticated()) {
				return new ResponseEntity<>("Welcome To TCS Company", HttpStatus.OK);
			}
		

		return new ResponseEntity<>("Invalid Credentials", HttpStatus.BAD_REQUEST);
	}

	
	@PostMapping("/register")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {

		String encodedPwd = pwdEncoder.encode(customer.getPwd());
		customer.setPwd(encodedPwd);

		customerRepo.save(customer);

		return new ResponseEntity<>("Customer Registered", HttpStatus.CREATED);

	}
	
}
