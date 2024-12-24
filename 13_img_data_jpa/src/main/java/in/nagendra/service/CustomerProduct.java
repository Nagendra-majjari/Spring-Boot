package in.nagendra.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.entity.Customer;
import in.nagendra.entity.Product;
import in.nagendra.repo.CustomerRepo;
import in.nagendra.repo.ProductRepo;
import jakarta.transaction.Transactional;

@Service
public class CustomerProduct {
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Transactional(rollbackOn = Exception.class)
	public void saveCustomerProduct() throws IOException {
		
		byte[] status = Files.readAllBytes(Paths.get("C:/Users/nagen/OneDrive/Pictures/Java Real-time Project template(1).jpg"));
		Customer c = new Customer();
		
		c.setImage(status);
		
        c.setName("sreeja");
		c.setAge(35);
		c.setGender("Female");
		
		customerRepo.save(c);
		byte[] report = Files.readAllBytes(Paths.get("C:/Users/nagen/OneDrive/Pictures/Java full stack development template.jpg"));
        Product p = new Product();
        
        p.setImage(report);
        p.setPname("mobile");
		p.setUsername("nagendra");
		p.setLocation("Hyderabad");
		
		productRepo.save(p);
		
		
	}
	public void getData() {
		List<Customer> all = customerRepo.findAll();
		System.out.println(all);
	}

}
