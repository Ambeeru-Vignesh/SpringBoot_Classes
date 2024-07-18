package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.dto;

import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long EmployeeID;

    @NotBlank(message = "Name of the employee cannot be blank")
    @Size(min = 3, max = 10, message = "Number of characters in name should be in the range:[3,10]")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age of the employee cannot be blank")
    @Max(value = 80, message = "Age of the employee cannot be greater than 80")
    @Min(value = 18, message = "Age of the employee cannot be lesser than 18")
    private Integer age;

    @NotBlank(message = "Role of the employee cannot be blank")
    //@Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary of the employee should not be null")
    @Positive(message = "Salary of the employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The Salary can be in the form of XXXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "10000.99")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
