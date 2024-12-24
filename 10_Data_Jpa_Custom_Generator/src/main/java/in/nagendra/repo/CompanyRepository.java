package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
