package Testing.spring.boot.repositories;

import Testing.spring.boot.TestcontainersConfiguration;
import Testing.spring.boot.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Import(TestcontainersConfiguration.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .id(1L)
                .name("Vignesh")
                .email("vignesh@gmail.com")
                .salary(400L)
                .build();
    }

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {
        // Arrange, Given
        employeeRepository.save(employee);

        // Act, When
        List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());

        // Assert, Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList() {
        // Given
        String email = "notPresent.123@gmail.com";
        // When
        List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());
        // Then
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();
    }
}