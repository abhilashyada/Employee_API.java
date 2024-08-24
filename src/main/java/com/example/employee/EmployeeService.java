package com.example.employee;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;

import java.util.*;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();

    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    int uniqueId = 7;

    @Override
    public ArrayList<Employee> getEmployees() {
        Collection<Employee> employeeCollection = employeeList.values();
        ArrayList<Employee> employees = new ArrayList<>(employeeCollection);

        return employees;
    }

    @Override
    public Employee getEmployeeId(int employeeId) {
        Employee employee = employeeList.get(employeeId);

        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeId(uniqueId);
        employeeList.put(uniqueId, employee);

        uniqueId += 1;
        return employee;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        Employee existingEmployee = employeeList.get(employeeId);

        if (existingEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (employee.getEmployeeName() != null) {
            existingEmployee.setEmployeeName(employee.getEmployeeName());
        }
        if (employee.getEmail() != null) {
            existingEmployee.setEmail(employee.getEmail());
        }
        if (employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee employee = employeeList.get(employeeId);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            employeeList.remove(employeeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
