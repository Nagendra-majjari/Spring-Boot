package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.entity.Product;

public interface ProductRepo extends JpaRepository<Product , Integer>{

}
