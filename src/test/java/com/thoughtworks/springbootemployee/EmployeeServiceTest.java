package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.Model.Employee;
import com.thoughtworks.springbootemployee.controller.EmployeeController;
import com.thoughtworks.springbootemployee.Repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.Service.EmployeeService;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.assertj.core.util.Arrays;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTest {

    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    Employee employee = new Employee(1, "test", 18, "male", 100000);
    List<Employee> employees = asList(new Employee(), new Employee());
    EmployeeService employeeService = new EmployeeService(employeeRepository);

    @Test
    void should_return_all_employees_when_get_all_given_all_employees() {
        //given
        when(employeeRepository.getEmployeesList()).thenReturn(employees);

        //when
        List<Employee> actual = employeeService.getEmployeesList();

        //then
        assertEquals(2, actual.size());
    }

}
//
//    @Test
//    void should_return_created_employee_given_no_employee_in_database_employee(){
//        //given
//        EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
//        EmployeeService employeeService = new EmployeeService(employeeRepository);
//        final Employee employee = new Employee(1, "test", 18, "male", 100000);
//
//
//        //when
//        final Employee actual = employeeService.create(employee);
//
//        //then
//        assertEquals(employee, actual);
//    }
//}
