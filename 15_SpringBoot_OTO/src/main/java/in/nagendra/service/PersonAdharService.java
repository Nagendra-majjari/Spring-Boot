package in.nagendra.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.entity.Adhar;
import in.nagendra.entity.Person;
import in.nagendra.repo.AdharRepo;
import in.nagendra.repo.PersonRepo;

@Service
public class PersonAdharService {
	
	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private AdharRepo adharRepo;
	
	
	public void saveData() {
		Person person = new Person();
		person.setPname("Pradeep");
		person.setGender("male");
		person.setPlace("Kadapa");
		
		Person savePerson = personRepo.save(person);
		
		Adhar adhar = new Adhar();
		adhar.setAdharNum(23988329029L);
		adhar.setIssuedDate(LocalDate.now());
		
		adhar.setPerson(savePerson);
		
		adharRepo.save(adhar);
		
		
	}
	
	public void getPerson() {
		Optional<Person> byId = personRepo.findById(1);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}
	}
	
	public void deletePerson() {
		personRepo.deleteById(3);
	}
	
	public void getAdhar() {
		Optional<Adhar> byId = adharRepo.findById(2);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}
		
	}
	
	public void deleteAdhar() {
		adharRepo.deleteById(3);
	}

}
