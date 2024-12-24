package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				      SpringApplication.run(Application.class, args);
		
		System.out.println("Implementation class"+context.getClass().getName());
		
		UserService us = context.getBean(UserService.class);
		
//		us.saveUser();
//		
//		us.saveAllUser();
//		
//		us.getUser(6302);
		
//		us.getUsers();
		
		us.getCount();
	}

}
