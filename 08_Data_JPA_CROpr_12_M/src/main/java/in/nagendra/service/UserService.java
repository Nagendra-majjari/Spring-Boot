package in.nagendra.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.nagendra.entity.User;
import in.nagendra.repo.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {

		this.userRepo = userRepo;
		System.out.println("Implementation Class" + userRepo.getClass().getName());
	}
	public void getUser(Integer id) {
		Optional<User> byId = userRepo.findById(id);
		
		if(byId.isPresent()) {
			System.out.println(byId);
		}
		else {
			System.out.println("User is not found");
		}
	}
	
	public void getUsers(){
		  
		List<Integer> asList = Arrays.asList(3201,3202,3203);
		
	     Iterable<User> allById = userRepo.findAllById(asList);
	     
	     for(User ByIds:allById) {
	    	 System.out.println(ByIds);
	     }
	    	
//	     allById.forEach(u->{
//	    	 System.out.println(u);
//	     });
//	     
	}
	
//	public void delateUser() {
//		
//		Iterable<User> all = userRepo.findAll();
//		
//		userRepo.delete(all);
//	}
	
	public void getCount() {
		long count = userRepo.count();
		
		System.out.println(count);
	}

	public void saveUser() {
		User u1 = new User();

		u1.setEmployee_id(3201);
		u1.setName("sreeja");
		u1.setPosition("HR");
		u1.setSalary(800000);

		userRepo.save(u1);
	}

	public void saveAllUser() {
		User u2 = new User();

		u2.setEmployee_id(3202);
		u2.setName("nagendra");
		u2.setPosition("CR");
		u2.setSalary(700000);

		userRepo.save(u2);

		User u3 = new User();

		u3.setEmployee_id(3203);
		u3.setName("mohan");
		u3.setPosition("HR");
		u3.setSalary(900000);

		userRepo.save(u3);

		User u4 = new User();

		u4.setEmployee_id(3204);
		u4.setName("ramya");
		u4.setPosition("HR");
		u4.setSalary(850000);

		userRepo.save(u4);

		User u5 = new User();

		u5.setEmployee_id(3205);
		u5.setName("nagaiah");
		u5.setPosition("CR");
		u5.setSalary(870000);

		userRepo.save(u5);
	}

}
