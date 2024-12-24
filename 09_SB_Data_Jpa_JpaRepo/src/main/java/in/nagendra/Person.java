package in.nagendra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Persons_JpaRepo")
public class Person {
	@Id
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String country;
	
	
	
	
	
	

}
