package in.nagendra;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.nagendra.d1.service.H2Service;
import in.nagendra.d2.service.MySQLService;

@SpringBootApplication
public class MultiDatabaseApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MultiDatabaseApplication.class, args);

		H2Service bean = context.getBean(H2Service.class);

		MySQLService service = context.getBean(MySQLService.class);

		bean.saveMySQLData();

		service.saveH2data();

	}
}
