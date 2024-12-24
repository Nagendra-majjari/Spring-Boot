package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = 
				    SpringApplication.run(Application.class, args);
		
		PersonService bean = run.getBean(PersonService.class);
		
//		bean.savePersons();
		
//		bean.getPesons();
		
//		bean.getPersonSort();
		
//		bean.getPersonPagination();
		
		bean.getPersonQBE("female", "india");
	}

}
