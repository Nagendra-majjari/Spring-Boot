package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.service.PersonAdharService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				        SpringApplication.run(Application.class, args);
		
		PersonAdharService bean = context.getBean(PersonAdharService.class);
		
		
		 // bean.saveData();
		  
		 // bean.getPerson();
		
		 // bean.getAdhar();
		
		 // bean.deletePerson();
		
		 bean.deleteAdhar();
		 
	}

}
