package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{employeeId}")
    public Employee update(@PathVariable Integer employeeId, @RequestBody Employee employeeUpdate) {
        this.employeeList.stream()
            .filter(employee -> employeeId.equals(employee.getId()))
            .findFirst()
            .ifPresent(employee -> {
                this.employeeList.remove(employee);
                this.employeeList.add(employeeUpdate);
            });

        return employeeUpdate;
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer employeeId) {
        this.employeeList.stream()
            .filter(employee -> employeeId.equals(employee.getId()))
            .findFirst()
            .ifPresent(employee -> this.employeeList.remove(employee));
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployee(@PathVariable Integer employeeId) {
        return employeeList.stream().filter(employee -> employee.getId().equals(employeeId)).findFirst().orElse(null);
    }
}
