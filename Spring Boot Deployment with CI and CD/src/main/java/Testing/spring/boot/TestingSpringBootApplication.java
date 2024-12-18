package Testing.spring.boot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class TestingSpringBootApplication implements CommandLineRunner {

	@Value("${my.variable}")
	private String myVariable;

	public static void main(String[] args) {
		SpringApplication.run(TestingSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("my variable: " + myVariable);
	}
}
