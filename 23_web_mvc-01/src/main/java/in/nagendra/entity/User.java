package in.nagendra.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uid;
	
	@NotEmpty(message = "Name is Mandetory")
	private String name;
	
	@NotEmpty(message = "Email is Mandetory")
	@Email(message = "Enter a valid Email")
	private String email;
	
	@NotNull(message = "Phone Number is Mandetory")
	private Long phno;
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createdAt;
	
	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDate updatedAt;

}
