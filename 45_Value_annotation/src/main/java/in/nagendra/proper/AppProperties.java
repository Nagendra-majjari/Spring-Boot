package in.nagendra.proper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	
	private Map<String , String> msg = new HashMap<>();
	
    
	
}
