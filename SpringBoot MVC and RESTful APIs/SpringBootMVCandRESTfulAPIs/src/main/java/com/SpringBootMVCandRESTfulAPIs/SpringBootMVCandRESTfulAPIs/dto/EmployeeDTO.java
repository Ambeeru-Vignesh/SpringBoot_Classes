package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long EmployeeID;
    private String Name;
    private String Email;
    private Integer Age;
    private LocalDate DateOfJoining;
    private Boolean isActive;

    public EmployeeDTO(){

    }

    public EmployeeDTO(Long employeeID, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        EmployeeID = employeeID;
        Name = name;
        Email = email;
        Age = age;
        DateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Long getEmployeeID() {
        return EmployeeID;
    }
    public void setEmployeeID(Long employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public LocalDate getDateOfJoining() {
        return DateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        DateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
