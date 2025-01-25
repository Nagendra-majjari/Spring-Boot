package in.nagendra.binding;

import java.sql.Date;

import lombok.Data;

@Data
public class Ticket {
	
	private Integer ticketId;
	private String ticketStatus;
	private Long trainNum;
	private String name;
	private String email;
	private Date dob;
	private String gender;
	private Date doj;
	private String source;
	private String destination;
	

}
