package com.thoughtworks.springbootemployee.Service;

import com.thoughtworks.springbootemployee.Model.Employee;
import com.thoughtworks.springbootemployee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getEmployeesList() {
        return employeeRepository.getEmployeesList();
    }

//    public List<Employee> getAll(){
//        return employeeRepository.findAll();
//    }
//
//    public Employee create(Employee employeeRequest){
//        return employeeRepository.create(employeeRequest);
//    }
}
