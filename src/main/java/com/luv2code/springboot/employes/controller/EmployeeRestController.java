package com.luv2code.springboot.employes.controller;

import com.luv2code.springboot.employes.entity.Employee;
import com.luv2code.springboot.employes.request.EmployeeRequest;
import com.luv2code.springboot.employes.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name="Employee Rest API Endpoints", description = "Operations related to employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }


    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Employee> findAll() {return employeeService.findAll();}

    @Operation(summary = "Get a single employee", description = "Retrieve an employee by Id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable @Min(value = 1) long employeeId){
        Employee theEmployee = employeeService.findByID(employeeId);
        return theEmployee;
    }


    @Operation(summary = "Create a new employee", description = "Add a new employee in the DB")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @Operation(summary = "Update an employee", description = "Update an employee")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value = 1) long employeeId, @Valid @RequestBody EmployeeRequest employeeRequest){
        Employee dbEmployee = employeeService.update(employeeId, employeeRequest);
        return dbEmployee;
    }

    @Operation(summary = "Delete a guy", description = "You heard me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value = 1) long employeeId){
        employeeService.deleteById(employeeId);
    }

}
