package com.thoughtworks.springbootemployee.controller;

import java.util.function.Supplier;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(){
        super("Employee Not Found.");
    }
}
