package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.entity.Person;

public interface PersonRepo extends JpaRepository<Person , Integer>{
}
