package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeList;
    }

    @GetMapping(params = {
        "page",
        "pageSize"
    })
    public List<Employee> getAll(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        int pageToSkip = page - 1;
        return employeeList.stream()
            .skip(pageToSkip)
            .limit(pageSize)
            .collect(Collectors.toList());
    }

    @GetMapping(params = {
        "gender"
    })
    public List<Employee> getAll(@RequestParam("gender") String gender) {
        return employeeList.stream()
            .filter(employee -> gender.equals(employee.getGender()))
            .collect(Collectors.toList());
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
