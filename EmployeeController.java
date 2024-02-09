package com.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

 @Autowired
 private EmployeeService employeeService;

 @GetMapping("/home")
 public String viewHomePage(Model model) {
     List<Employee> employees = employeeService.getAllEmployees();
     model.addAttribute("employees", employees);
     return "home";
 }

 @GetMapping("/showCreateForm")
 public String showCreateForm(Model model) {
     model.addAttribute("employee", new Employee());
     return "create";
 }

 @PostMapping("/saveEmployee")
 public String saveEmployee(@ModelAttribute("employee") Employee employee) {
     employeeService.saveEmployee(employee);
     return "redirect:/home";
 }

 @GetMapping("/showUpdateForm/{id}")
 public String showUpdateForm(@PathVariable("id") Long id, Model model) {
     Employee employee = employeeService.getEmployeeById(id);
     model.addAttribute("employee", employee);
     return "update";
 }

 @PostMapping("/updateEmployee/{id}")
 public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute("employee") Employee employee) {
     employeeService.updateEmployee(employee);
     return "redirect:/home";
 }

 @GetMapping("/deleteEmployee/{id}")
 public String deleteEmployee(@PathVariable("id") Long id) {
     employeeService.deleteEmployee(id);
     return "redirect:/home";
 }
}
