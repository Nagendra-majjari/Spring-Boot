package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.nagendra.binding.Quote;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		//getWelcomeMsg();
		
		getRandomQuote1();
		
		System.out.println("--------------------------------------------");
		
		getRandomQuote2();
	}

	public static void getWelcomeMsg() {
		String apiUrl = "https://api.restful-api.dev/objects/";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> forEntity = rt.getForEntity(apiUrl, String.class);

		int value = forEntity.getStatusCode().value();

		String body = forEntity.getBody();

		System.out.println(value);

		System.out.println(body);
	}

	public static void getRandomQuote1() {

		String apiUrl = "https://dummyjson.com/quotes/random";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> forEntity = rt.getForEntity(apiUrl, String.class);

		String body = forEntity.getBody();
		
		System.out.println(body);

		

	}
	
	

	public static void getRandomQuote2() {
		
		String apiUrl = "https://dummyjson.com/quotes/random";
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Quote> forEntity = rt.getForEntity(apiUrl, Quote.class);
		
		Quote body = forEntity.getBody();
		
		System.out.println(body);
		
	}
}



























