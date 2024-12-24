package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        in.nagendra.customGen.CustomIdGenerator.setDataSource(context.getBean(javax.sql.DataSource.class));

        UserService userService = context.getBean(UserService.class);
        userService.dataIns();
    }
}
