package in.nagendra.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	private Integer id;
	private String ename;
	private Double salary;

}
