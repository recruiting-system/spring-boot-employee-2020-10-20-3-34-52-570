package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeList;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {

        this.employeeList.add(employee);
        return employee;
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployee(@PathVariable Integer employeeId) {
        return employeeList.stream().filter(employee -> employee.getId().equals(employeeId)).findFirst().orElse(null);
    }
}
