package com.dfarrow00.employeerestcrud.service;

import com.dfarrow00.employeerestcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
