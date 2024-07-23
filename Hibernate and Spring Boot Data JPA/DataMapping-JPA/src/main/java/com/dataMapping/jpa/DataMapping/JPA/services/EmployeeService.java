package com.dataMapping.jpa.DataMapping.JPA.services;


import com.dataMapping.jpa.DataMapping.JPA.entities.EmployeeEntity;
import com.dataMapping.jpa.DataMapping.JPA.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
