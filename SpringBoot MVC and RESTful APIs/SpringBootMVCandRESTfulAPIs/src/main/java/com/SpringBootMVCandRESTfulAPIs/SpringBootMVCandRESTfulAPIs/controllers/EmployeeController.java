package com.SpringBootMVCandRESTfulAPIs.SpringBootMVCandRESTfulAPIs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "/hello")
    public String getMySecretMessage(){
        return "Hello friend";
    }
}
