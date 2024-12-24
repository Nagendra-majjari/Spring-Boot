package in.nagendra.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.nagendra.entity.User;
import jakarta.transaction.Transactional;

public interface UserRepository extends CrudRepository<User,Integer>{
	
	@Transactional
	@Modifying
	@Query("Insert into User( id , name,country,gender) values(:id,:name,:country,:gender)")
	public void insertData (int id , String name , String country , String gender );

}
