package in.nagendra;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.service.CustomerProduct;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctxt =
				       SpringApplication.run(Application.class, args);
		
		CustomerProduct bean = ctxt.getBean(CustomerProduct.class);
		
		bean.getData();
		bean.saveCustomerProduct();
		
	}

}
