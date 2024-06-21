package com.dfarrow00.employeerestcrud.dao;

import com.dfarrow00.employeerestcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
