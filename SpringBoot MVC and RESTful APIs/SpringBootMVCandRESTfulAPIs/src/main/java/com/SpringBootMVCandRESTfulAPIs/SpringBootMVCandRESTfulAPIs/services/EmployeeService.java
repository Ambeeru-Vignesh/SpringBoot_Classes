package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.services;


import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.dto.EmployeeDTO;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.entities.EmployeeEntity;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.exceptions.ResourceNotFoundException;
import com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeByID(Long id) {

        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }


    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeID(EmployeeDTO employeeDTO, Long employeeID) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setID(employeeID);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public void isExistsByEmployeeID(long employeeID) {
        boolean exists = employeeRepository.existsById(employeeID);
        if(!exists) throw new ResourceNotFoundException("Employee not found with id: "+employeeID);
    }

    public boolean deleteEmployeeByID(Long employeeID) {
        isExistsByEmployeeID(employeeID);
        employeeRepository.deleteById(employeeID);
        return true;
    }


    public EmployeeDTO updatePartialEmployeeByID(Long employeeID, Map<String, Object> updates) {
        isExistsByEmployeeID(employeeID);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeID).get();
        updates.forEach((field, value)-> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }
}