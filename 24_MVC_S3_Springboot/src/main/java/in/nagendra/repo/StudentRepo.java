package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.entity.Student;

public interface StudentRepo extends JpaRepository<Student ,Integer>{

}
