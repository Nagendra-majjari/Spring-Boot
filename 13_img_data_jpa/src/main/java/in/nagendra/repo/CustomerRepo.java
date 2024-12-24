package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer , Integer>{

}
