package in.nagendra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.entity.Company;
import in.nagendra.repo.CompanyRepository;
import jakarta.transaction.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepo;

    @Transactional
    public void saveCompanys() {
        Company company = new Company();
        
        company.setName("Nagendra");
        company.setAge(21);
        company.setGender("Male");
        company.setCountry("India");
        company.setPosition("HR");

        Company savedCompany = companyRepo.save(company);
        System.out.println("Saved Company: " + savedCompany);
    }
}
