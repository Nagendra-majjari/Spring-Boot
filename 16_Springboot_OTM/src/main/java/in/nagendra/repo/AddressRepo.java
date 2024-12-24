package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.Entity.Address;

public interface AddressRepo extends JpaRepository<Address , Integer>{

}
