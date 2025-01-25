package in.nagendra.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nagendra.dto.StudentOrder;

public interface StudentOrderRepo extends JpaRepository<StudentOrder,Integer>{
	
	
	public StudentOrder findByRazorpayOrderId(String orderId);

}
