package com.assignment.springbootassignment.service;

import com.assignment.springbootassignment.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee getEmployee(long id);

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee, Long empId);

    public void deleteEmployee(long id);
}
