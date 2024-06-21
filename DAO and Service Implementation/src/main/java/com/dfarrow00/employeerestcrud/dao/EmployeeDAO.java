package com.dfarrow00.employeerestcrud.dao;

import com.dfarrow00.employeerestcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
