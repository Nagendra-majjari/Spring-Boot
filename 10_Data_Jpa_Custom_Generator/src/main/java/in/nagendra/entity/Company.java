package in.nagendra.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(generator = "company-id-generator")
    @GenericGenerator(name = "company-id-generator", strategy = "in.nagendra.gen.CompanyGen")
    private String id;
    private String name;
    private Integer age;
    private String gender;
    private String country;
    private String position;
}
