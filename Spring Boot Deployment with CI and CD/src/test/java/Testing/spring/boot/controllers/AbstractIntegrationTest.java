package Testing.spring.boot.controllers;


import Testing.spring.boot.TestcontainersConfiguration;
import Testing.spring.boot.dto.EmployeeDto;
import Testing.spring.boot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient(timeout = "100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
public class AbstractIntegrationTest {

    @Autowired
    WebTestClient webTestClient;

    Employee testEmployee = Employee.builder()
            .id(1L)
            .email("Vignesh@gmail.com")
            .name("Vignesh Ambeeru")
            .salary(400L)
            .build();

    EmployeeDto testEmployeeDto = EmployeeDto.builder()
            .id(1L)
            .email("Vignesh@gmail.com")
            .name("Vignesh")
            .salary(400L)
            .build();
}
