package in.nagendra.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nagendra.Entity.Address;
import in.nagendra.Entity.Employee;
import in.nagendra.repo.AddressRepo;
import in.nagendra.repo.EmpRepo;

@Service
public class EmployeeWithAddress {

	@Autowired
	private AddressRepo addre;
	
	@Autowired
	private EmpRepo empRepo;
	
	public void getEmployee(){
		Optional<Employee> byId = empRepo.findById(2);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}
	}
	
	public void getAddress() {
		Optional<Address> byId = addre.findById(3);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}
		
	}
	
	public void deleteEmployee() {
		
		empRepo.deleteById(5);
	}
	
	public void deleteAddress() {
		addre.deleteById(3);
	}
	
	public void saveData() {
		Employee e = new Employee();
		e.setEmpName("gokual");
		e.setSalary(100000l);
		
		Address a1 = new Address();
		a1.setCity("badvel");
		a1.setState("kadapa");
		a1.setType("perminant");
		
		Address a2 = new Address();
		a2.setCity("kadapa");
		a2.setState("kadapa");
		a2.setType("present");
		
		List<Address> list = Arrays.asList(a1 ,a2);
		e.setAddr(list);
		
		a1.setEmp(e);
		a2.setEmp(e);
		
		empRepo.save(e);
		
		
		
	}
	
	
	
}















