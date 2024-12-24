package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.repo.UserRepository;
import in.nagendra.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				     SpringApplication.run(Application.class, args);
		
		UserService service = context.getBean(UserService.class);
		
		service.saveUser();
	}

}
