package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.pojo.Employee;
import in.nagendra.repo.EmployeeRepository;
import in.nagendra.repo.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				      SpringApplication.run(Application.class, args);
		
		EmployeeRepository empRepo = context.getBean(EmployeeRepository.class);
		
		System.out.println("Impl interface::" + empRepo.getClass().getName());
		
		Employee e = new Employee();
		
		e.setId(103);
		e.setEname("nagaiah");
		e.setSalary(2000000.00);
		
		
		
		empRepo.save(e);
	}

}
