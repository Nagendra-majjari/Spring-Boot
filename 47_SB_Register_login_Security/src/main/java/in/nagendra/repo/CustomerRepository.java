package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Integer>{
	
	public Customer findByEmail(String email);

}
