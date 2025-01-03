package in.nagendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import in.nagendra.bindings.Quote;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		getRandonQuote1();
		getRandomQuote2();
	}

	public static void getRandonQuote1() {

		String apiUrl = "https://dummyjson.com/quotes/random";

		WebClient webClient = WebClient.create();

		Mono<String> bodyToMono = webClient.get()
				                           .uri(apiUrl)
				                           .retrieve()
				                           .bodyToMono(String.class);

		String block = bodyToMono.block();
		
		System.out.println(block);
	}

	
	public static void getRandomQuote2() {
		
		String apiUrl = "https://dummyjson.com/quotes/random";
		
		WebClient webClient = WebClient.create();
		
		Mono<Quote> bodyToMono = webClient.get()
				                          .uri(apiUrl)
				                          .retrieve()
				                          .bodyToMono(Quote.class);
		
		Quote block = bodyToMono.block();
		
		System.out.println(block);
		
	}
}








