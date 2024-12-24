package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = 
				SpringApplication.run(Application.class, args);
		
		ProductService service = ctxt.getBean(ProductService.class);
		
		service.saveProduct();
	}

}
