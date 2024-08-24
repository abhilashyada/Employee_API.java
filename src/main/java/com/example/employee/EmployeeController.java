package com.example.employee;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.employee.*;
import com.example.employee.EmployeeService;
import com.example.employee.Employee;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    EmployeeService employeeservice = new EmployeeService();

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return employeeservice.getEmployees();
    }

    @GetMapping("employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
        return employeeservice.getEmployeeId(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeservice.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
        return employeeservice.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeservice.deleteEmployee(employeeId);
    }

}