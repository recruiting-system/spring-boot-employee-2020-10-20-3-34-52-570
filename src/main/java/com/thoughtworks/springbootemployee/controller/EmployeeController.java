package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    @GetMapping
    public List<Employee> getEmployeesList(){
        return employees;
    }
}
