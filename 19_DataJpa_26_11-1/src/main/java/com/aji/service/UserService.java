package com.aji.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aji.entity.User;
import com.aji.repo.UserRepo;

import jakarta.transaction.Transactional;
@Service
public class UserService {
	private UserRepo user;

	public UserService(UserRepo user) {
		this.user = user;
	}
	
	public void deleteAll() {
		user.deleteAll();
	}
	public void SaveAll() {
		User user1=new User();
		user1.setId(101);
		user1.setGender("male");
		user1.setCountry("india");
		user1.setName("ajith1");
		user.save(user1);
		User user2=new User();
		user2.setId(102);
		user2.setGender("female");
		user2.setCountry("india");
		user2.setName("bhavani");
		User user3=new User();
		user3.setId(103);
		user3.setGender("male");
		user3.setCountry("india");
		user3.setName("bhanu");
		User user4=new User();
		user4.setId(104);
		user4.setGender("male");
		user4.setCountry("india");
		user4.setName("vinod");
	    user.saveAll(Arrays.asList(user1,user2,user3,user4));
	}
	public void saveUser() {
		User user1=new User();
		user1.setId(101);
		user1.setGender("male");
		user1.setCountry("india");
		user1.setName("ajith1");
		user.save(user1);
	}
	public  void findAll() {
		Iterable<User> all = user.findAll();
	     for (User user : all) {
	    	 System.out.println(user);
	     }
		
	}
	
	public void findId() {
		Optional<User> id = user.findById(102);
		System.out.println(id);
	}
	public void findIdAll() {
		Iterable<User> byId = user.findAllById(Arrays.asList(101,102));
		for(User id:byId) {
			System.out.println(id);
		}
	}
	public void exitId() {
		boolean b = user.existsById(102);
		if(b==true)
			System.out.println("record found..");
		else
			System.out.println("record not found..");
	}
	public long count() {
		return user.count();
	}
	public void getUsersFindBy(String country) {
		List<User> country2 = user.findByCountry(country);
		country2.forEach(System.out::println);
	}
	public void getUsersByCounName(String country,String name) {
		List<User> name2 = user.findByCountryAndName(country, name);
		name2.forEach(System.out::println);
	}
	public void allUsersByHql() {
		List<User> users = user.getAllUsers();
		users.forEach(System.out::println);
	}
	public void allUsersBySql() {
		List<User> users = user.getAllUsersSql();
		users.forEach(System.out::println);
	}
    public void insertData(Integer id, String name, String country, String gender) {
        user.insertDataHql(id, name, country, gender);
        System.out.println("Data inserted successfully...");
    }
	public void deleteData(Integer id) {
		user.deleteHql(id);
		System.out.println("data deleted sucessfully...6");
	}
	
	public void updateData(String name,String country,Integer id) {
		user.updateHql(name, country, id);
		System.out.println("data is updated sucessfully...");
	}
	@Transactional
	public void insertList() {
		User user4=new User();
		user4.setId(107);
		user4.setGender("female");
		user4.setCountry("india");
		user4.setName("mounika");
		User user1=new User();
		user1.setId(108);
		user1.setGender("female");
		user1.setCountry("india");
		user1.setName("bhavani2");
		 Arrays.asList(user4, user1).forEach(users -> 
         user.insertDataHql1(users.getId(), users.getName(), users.getCountry(), users.getGender())
     );
		
	}
}
