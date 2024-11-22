package Testing.spring.boot;

import org.springframework.boot.SpringApplication;

public class TestTestingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestingSpringBootApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
