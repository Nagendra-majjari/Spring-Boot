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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employee_tbl")
public class User {
	
	@Id
	@Column(name="Employee_Id")
	private Integer id;
	private String name;
	private String country;
	private String gender;
	
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createdate;
	
	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDate updatedate;
	
	

}
