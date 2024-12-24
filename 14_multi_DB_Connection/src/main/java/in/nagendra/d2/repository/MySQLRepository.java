package in.nagendra.d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.d2.entity.MySQLEntity;

public interface MySQLRepository extends JpaRepository<MySQLEntity, Long> {

}
