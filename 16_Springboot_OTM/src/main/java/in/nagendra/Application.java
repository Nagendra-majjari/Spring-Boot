package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.service.EmployeeWithAddress;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmployeeWithAddress address = context.getBean(EmployeeWithAddress.class);
		
		//address.saveData();
		
		//address.getEmployee();
		
		//address.getAddress();
		
		//address.deleteEmployee();
		
		address.deleteAddress();
	}

}
