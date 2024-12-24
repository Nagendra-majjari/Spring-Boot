package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.entity.User;

public interface UserRepository extends JpaRepository<User , Integer>{

}
