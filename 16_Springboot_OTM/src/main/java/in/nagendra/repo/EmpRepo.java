package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.Entity.Employee;

public interface EmpRepo extends JpaRepository<Employee , Integer>{

}
