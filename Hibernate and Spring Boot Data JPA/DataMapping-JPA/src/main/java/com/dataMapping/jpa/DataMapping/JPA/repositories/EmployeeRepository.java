package com.dataMapping.jpa.DataMapping.JPA.repositories;

import com.dataMapping.jpa.DataMapping.JPA.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
