package in.nagendra.service;

import org.springframework.stereotype.Service;

import in.nagendra.repo.UserRepository;
@Service
public class UserService {
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
		System.out.println("Impl class name::"+userRepo.getClass().getName());
	}
	
	public void dataInsert() {
//		User u1 = new User();
//		
//		u1.setId(2001);
//		u1.setName("Gowtham");
//		u1.setCountry("India");
//		u1.setGender("Male");
		
		userRepo.insertData(2001, "gowtham", "india", "male");
		
	}

}
