package com.dataMapping.jpa.DataMapping.JPA.repositories;

import com.dataMapping.jpa.DataMapping.JPA.entities.DepartmentEntity;
import com.dataMapping.jpa.DataMapping.JPA.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
