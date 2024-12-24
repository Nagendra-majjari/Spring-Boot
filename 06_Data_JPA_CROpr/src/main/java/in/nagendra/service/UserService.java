package in.nagendra.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import in.nagendra.entity.User;
import in.nagendra.repo.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
		System.out.println("Implementation Class ::" + userRepo.getClass().getName());
	}
	
//	public void getAllUsers() {
//		Iterable<User> all = userRepo.findAll();
//		
//		for(User alls:all) {
//			System.out.println(all);
//		}
//	}
//	public void findBygender() {
//		List<User> byGender = userRepo.findByGender("Male");
//		
//		byGender.forEach(u->{
//			System.out.println(u);
//		});	
//	}
//	
	public void getValues() {
		List<User> genderAndCountry = userRepo.findByGenderAndCountry("female", "USA");
		
		genderAndCountry.forEach(System.out::println);
		
	}
	
//	public void getAllUsers() {
//		Iterable<User> all = userRepo.findAll();
//		
//		all.forEach(u ->{
//			System.out.println(u);
//		});
//	}
	
//	public void getUserById( Integer id) {
//		Optional<User> byId = userRepo.findById(id);
//		
//		if(byId.isPresent()) {
//			System.out.println(byId.get());
//		}
//		else {
//			System.out.println("User is not found");
//		}
//	}

//	public Collection<Iterable<User>> getAllUsersById(List<Integer> id) {
//		Iterable<User> allById = userRepo.findAllById(id);
//		Collection<Iterable<User>> asList = Arrays.asList(allById);
//		return asList;
//		
//	   
//		
//		 
//	}

//	public void saveUser() {
//
//		User u = new User();
//
//		u.setId(1001);
//		u.setName("nagendra");
//		u.setGender("male");
//		u.setCountry("INDIA");
//
//		userRepo.save(u);
//
//	}

//	public void saveUsers() {
//		User u1 = new User();
//
//		u1.setId(1002);
//		u1.setName("Nagaiah");
//		u1.setGender("Male");
//		u1.setCountry("USA");
//
//		userRepo.save(u1);
//		
//		User u2 = new User();
//
//		u2.setId(1003);
//		u2.setName("Lakshmi Devi");
//		u2.setGender("Female");
//		u2.setCountry("USA");
//
//		userRepo.save(u2);
//
//		User u3 = new User();
//
//		u3.setId(1005);
//		u3.setName("Lakshmi");
//		u3.setGender("Female");
//		u3.setCountry("USA");
//
//		userRepo.save(u3);
//
//		User u4 = new User();
//
//		u4.setId(1004);
//		u4.setName("Ramana");
//		u4.setGender("Male");
//		u4.setCountry("INDIA");
//
//		userRepo.save(u4);
//
//	}
//
}
