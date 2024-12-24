package in.nagendra.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.nagendra.Person;
import in.nagendra.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepo;

	public PersonService(PersonRepository personRepo) {
		super();
		this.personRepo = personRepo;
	}
	// Query By Example code....
	public void getPersonQBE(String gender,String country) {
		
		Person p = new Person();
		
		
		if(gender != null) {
			p.setGender(gender);
		}
		
		if(country != null) {
			p.setCountry(country);
		}
		
		Example<Person> of = Example.of(p);
		
		List<Person> all = personRepo.findAll(of);
		
		all.forEach(System.out::println);
	}
	//Pagination code....
	public void getPersonPagination() {
		int pagesize = 3;
		int page =2;
		
		PageRequest request = PageRequest.of(page -1, pagesize);
		
		Page<Person> all = personRepo.findAll(request);
		
		List<Person> content = all.getContent();
		
		content.forEach(System.out::println);
	}
	
	public void getPesons() {
		List<Person> all = personRepo.findAll();
		
		all.forEach(System.out::println);
	}
	//Sorting code....
	public void getPersonSort() {
		
		Sort sort = Sort.by("age").ascending();
		
		List<Person> all = personRepo.findAll(sort);
		
		all.forEach(System.out::println);
	}
	
	public void savePersons() {
		 
		Person p1 = new Person(101,"John",21,"male","India");
		Person p2 = new Person(102,"ram",23,"male","USA");
		Person p3 = new Person(103,"ramesh",41,"male","UK");
		Person p4 = new Person(104,"Ajith",31,"male","Japan");
		Person p5 = new Person(105,"kamal",28,"male","UK");
		Person p6 = new Person(106,"kiran",19,"male","India");
		Person p7 = new Person(107,"meghana",42,"female","India");
		Person p8 = new Person(108,"keerthi",51,"female","USA");
		Person p9= new Person(109,"pallavi",38,"female","Japan");
		
		List<Person> list = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9);
		
		personRepo.saveAll(list);
		
	}
	
	
}
