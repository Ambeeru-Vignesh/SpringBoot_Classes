package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long EmployeeID;
    private String Name;
    private String Email;
    private Integer Age;
    private LocalDate DateOfJoining;
    private Boolean isActive;
}
