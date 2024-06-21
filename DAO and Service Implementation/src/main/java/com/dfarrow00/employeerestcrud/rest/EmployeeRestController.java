package com.dfarrow00.employeerestcrud.rest;

import com.dfarrow00.employeerestcrud.entity.Employee;
import com.dfarrow00.employeerestcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.getById(employeeId);

        if (employee == null) throw new RuntimeException("Employee not found for id: " + employeeId);

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //To force save of new employee, even if an id is passed in JSON.
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.getById(employeeId);

        if (employee == null) throw new RuntimeException("Employee not found for id: " + employeeId);

        employeeService.deleteById(employeeId);
        return "Deleted employee with id: " + employeeId;
    }
}
