package com.employee.service;

import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
 List<Employee> getAllEmployees();
 Employee getEmployeeById(Long id);
 void saveEmployee(Employee employee);
 void updateEmployee(Employee employee);
 void deleteEmployee(Long id);
}
