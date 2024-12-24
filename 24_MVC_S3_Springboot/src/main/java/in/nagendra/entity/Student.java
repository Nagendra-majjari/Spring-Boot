package in.nagendra.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	
	@NotEmpty(message = "Name is required")
	private String name;
	
	@Email(message = "Invalid email")
	@NotEmpty(message = "Email is required")
	private String email;
	
	@Pattern(regexp = "\\d{10}", message = "Invalid phone number")
	private String phno;
	
	@Size(min = 1, message = "Please upload a resume.")
	@NotNull(message = "Resume is required.")
	private String resumeUrl;

	
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createdAt;
	
	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDate updatedAt;

}
