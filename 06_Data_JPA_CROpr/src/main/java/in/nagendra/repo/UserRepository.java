package in.nagendra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.nagendra.entity.User;
import jakarta.persistence.criteria.From;


public interface UserRepository extends CrudRepository<User,Integer>{
	
    
//	 public List<User> findByGender(String gender);
	 
	 public List<User> findByGenderAndCountry(String gender ,String country);
	
}