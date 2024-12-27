package in.nagendra;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) throws Exception {
		App a = new App();
		//a.convertJavaToJSON();
		
		a.convertJsonToJava();
		
	}

	public void convertJsonToJava() throws Exception{

		File f = new File("customer.json");
		
		ObjectMapper mapper = new ObjectMapper();

		Customer customer = mapper.readValue(f,Customer.class);
		
		System.out.println(customer);
		
	}

	public void convertJavaToJSON() throws Exception {

		Customer c = new Customer();

		c.setId(101);
		c.setName("nagendra");
		c.setPhno(9014648125l);

		File f = new File("customer.json");

		ObjectMapper mapper = new ObjectMapper();

		mapper.writeValue(f, c);

		System.out.println("Convertion is done successfully.....");
	}

}
