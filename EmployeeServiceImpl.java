package com.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeRepository employeeRepository;

 @Override
 public List<Employee> getAllEmployees() {
     return employeeRepository.findAll();
 }

 @Override
 public Employee getEmployeeById(Long id) {
     return employeeRepository.findById(id).orElse(null);
 }

 @Override
 public void saveEmployee(Employee employee) {
     employeeRepository.save(employee);
 }

 @Override
 public void updateEmployee(Employee employee) {
     // Implement update logic based on your requirements
     employeeRepository.save(employee);
 }

 @Override
 public void deleteEmployee(Long id) {
     employeeRepository.deleteById(id);
 }
}
