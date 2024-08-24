package com.example.employee;

import java.util.*;

import com.example.employee.*;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();

    Employee getEmployeeId(int employeeId);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(int employeeId, Employee employee);

    void deleteEmployee(int employeeId);
}