package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private List<Company> companyList = new ArrayList<>();

    @GetMapping
    public List<Company> getAll() {
        return this.companyList;
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        this.companyList.add(company);
        return company;
    }

}
