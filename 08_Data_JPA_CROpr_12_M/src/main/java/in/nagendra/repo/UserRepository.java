package in.nagendra.repo;

import org.springframework.data.repository.CrudRepository;

import in.nagendra.entity.User;

public interface UserRepository extends CrudRepository<User , Integer>{

}
