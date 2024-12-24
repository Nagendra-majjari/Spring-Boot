package in.nagendra.Runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCMDRunner implements CommandLineRunner {
	public MyCMDRunner() {
		System.out.println("MyCMDRunner :: Constructor");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyCMDRunner -run() method is called.....");
	}

}
