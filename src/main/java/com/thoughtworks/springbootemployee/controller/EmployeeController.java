package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employeeUpdate) {

        this.employees.stream()
                .filter(employee -> employeeId.equals(employee.getId()))
                .findFirst()
                .ifPresent(employee -> {
                    employees.remove(employee);
                    employees.add(employeeUpdate);
                });
        return employeeUpdate;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId) {
        this.employees.stream()
                .filter(employee -> employeeId.equals(employee.getId()))
                .findFirst()
                .ifPresent(employee -> {
                    employees.remove(employee);
                });
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeByID(@PathVariable Integer employeeId){
        return this.employees.stream()
                .filter(employee -> employeeId.equals(employee.getId()))
                .findFirst().get();
    }

    @GetMapping(params = "gender")
    public List<Employee> getEmployeeByGender(@RequestParam("gender") String gender) {
        return employees.stream()
                .filter(employee -> employee.getGender().equals(gender))
                .collect(Collectors.toList());
    }







}
