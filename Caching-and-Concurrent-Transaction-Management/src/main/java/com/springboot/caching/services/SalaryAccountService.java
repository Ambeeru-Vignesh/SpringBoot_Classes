package com.springboot.caching.services;


import com.springboot.caching.entities.Employee;
import com.springboot.caching.entities.SalaryAccount;

public interface SalaryAccountService {
    void createAccount(Employee employee);

    SalaryAccount incrementBalance(Long accountId);
}
