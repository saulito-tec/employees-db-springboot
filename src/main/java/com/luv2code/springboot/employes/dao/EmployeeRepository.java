package com.luv2code.springboot.employes.dao;

import com.luv2code.springboot.employes.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // That's it, no more code :)
}
