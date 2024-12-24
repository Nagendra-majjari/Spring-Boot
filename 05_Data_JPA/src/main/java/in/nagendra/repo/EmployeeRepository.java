package in.nagendra.repo;

import org.springframework.data.repository.CrudRepository;

import in.nagendra.pojo.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	

}
