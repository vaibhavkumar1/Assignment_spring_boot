package com.assignment.springbootassignment.service;

import com.assignment.springbootassignment.entity.Employee;
import com.assignment.springbootassignment.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIMP implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long empId) {
        return employeeRepository.findById(empId).get();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long empId) {
        Employee employee1= employeeRepository.findById(empId).get();
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpDesn(employee.getEmpDesn());
        employee1.setDepartment(employee.getDepartment());
        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee entity = employeeRepository.getById(id);
        employeeRepository.delete(entity);
    }
}
