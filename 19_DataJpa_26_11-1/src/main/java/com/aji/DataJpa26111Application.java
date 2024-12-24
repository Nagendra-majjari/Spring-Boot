package com.aji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aji.service.UserService;

@SpringBootApplication
public class DataJpa26111Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataJpa26111Application.class, args);
		UserService bean = context.getBean(UserService.class);
//		bean.deleteAll();
//		bean.SaveAll();
//		bean.findAll();
//		bean.findId();
//		bean.findIdAll();
//		bean.exitId();
//		System.out.println(bean.count());
//		bean.getUsersFindBy("india");
//		bean.getUsersByCounName("india","ajith1");
//    	bean.allUsersByHql();
//		bean.allUsersBySql();
//		bean.insertData(106,"jothy","india","female");
//		bean.deleteData(106);
//		bean.updateData("ajith1","India",101);
    	bean.insertList();
	}

}
