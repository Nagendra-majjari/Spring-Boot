package in.nagendra.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employees_Data")
public class User {
	
	
	@Id
	@Column(name="EMP_ID")
	private Integer Employee_id;
	private String name;
	private String position;
	private Integer salary;
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(insertable=true)
	private LocalDate updatedate;

}
