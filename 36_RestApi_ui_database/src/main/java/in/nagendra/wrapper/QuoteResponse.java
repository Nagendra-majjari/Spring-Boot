package in.nagendra.wrapper;

import java.util.List;

import in.nagendra.model.Quote;
import lombok.Data;

@Data
public class QuoteResponse {
	
	 private List<Quote> quotes;

}
