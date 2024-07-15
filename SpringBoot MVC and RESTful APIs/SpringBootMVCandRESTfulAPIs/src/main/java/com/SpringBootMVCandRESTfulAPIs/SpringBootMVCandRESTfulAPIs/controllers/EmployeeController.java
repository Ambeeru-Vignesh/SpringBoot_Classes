package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.controllers;

import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/hello")
//    public String getMySecretMessage(){
//        return "Hello friend";
//    }

    @GetMapping(path = "/{EmployeeID}")
    public EmployeeDTO getEmployeeByID(@PathVariable Long EmployeeID){
        return new EmployeeDTO(EmployeeID, "Vignesh", "vigneshvj53@gmail.com", 24, LocalDate.of(2023,7,16), true );
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String name){
        return "Hi Friend "+age+" "+name;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setEmployeeID((100L));
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployee(){
        return "Employee details successfully updated";
    }
}
