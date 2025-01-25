package in.nagendra.binding;

import java.sql.Date;

import lombok.Data;

@Data
public class Passenger {
	
	private String name;
	private String email;
	private Date dob;
	private String gender;
	private Date doj;
	private String source;
	private String destination;
	private Long trainNum;

}
