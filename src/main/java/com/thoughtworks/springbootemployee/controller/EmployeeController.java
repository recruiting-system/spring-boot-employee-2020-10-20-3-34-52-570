package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Employee;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employeeCreate) {
        employees.add(employeeCreate);
        return employeeCreate;
    }
}
