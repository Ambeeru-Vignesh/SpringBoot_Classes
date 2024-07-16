package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.controllers;

import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.dto.EmployeeDTO;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.entities.EmployeeEntity;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.repositories.EmployeeRepository;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/hello")
//    public String getMySecretMessage(){
//        return "Hello friend";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/{EmployeeID}")
    public EmployeeDTO getEmployeeByID(@PathVariable(name = "EmployeeID") Long id){
        return employeeService.getEmployeeByID(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                @RequestParam(required = false) String name){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping
    public String updateEmployee(){
        return "Employee details successfully updated";
    }
}
