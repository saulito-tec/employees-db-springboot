package com.luv2code.springboot.employes.dao;

import com.luv2code.springboot.employes.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByID(long theId);

    Employee save(Employee theEmployee);

    void deleteById(long theId);
}
