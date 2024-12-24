package in.nagendra.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.entity.User;
import in.nagendra.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public void saveUser() {
		User u1 = new User();
		
		u1.setName("nagendra");
		u1.setAge(21);
		u1.setCountry("INDIA");
		
		userRepo.save(u1);
	}
	
	

}
