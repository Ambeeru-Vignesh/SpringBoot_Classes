package com.production_ready_feature.clients.Impl;

import com.production_ready_feature.clients.EmployeeClient;
import com.production_ready_feature.dto.EmployeeDTO;

import java.util.List;

public class EmployeeClientImpl implements EmployeeClient {
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        return null;
    }
}
