package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.Person;

public interface PersonRepository extends JpaRepository<Person , Integer>{

}
