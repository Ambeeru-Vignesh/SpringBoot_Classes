package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.controllers;

import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.dto.EmployeeDTO;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.entities.EmployeeEntity;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.repositories.EmployeeRepository;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/{EmployeeID}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable(name = "EmployeeID") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeByID(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
                                @RequestParam(required = false) String name){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeID){
        return ResponseEntity.ok(employeeService.updateEmployeeID(employeeDTO, employeeID));
    }

    @DeleteMapping(path = "/{employeeID}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeID){
        boolean gotDeleted = employeeService.deleteEmployeeByID(employeeID);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@PathVariable Long employeeID, @RequestBody Map<String, Object> updates) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeByID(employeeID, updates);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

}