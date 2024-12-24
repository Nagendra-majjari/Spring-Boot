package in.nagendra.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Adhar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adharId;
	private Long adharNum;
	private LocalDate issuedDate;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person;

}
