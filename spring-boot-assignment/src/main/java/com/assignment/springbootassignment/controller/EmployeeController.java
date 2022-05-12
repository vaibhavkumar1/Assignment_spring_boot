package com.assignment.springbootassignment.controller;

import com.assignment.springbootassignment.dto.EmployeeDto;
import com.assignment.springbootassignment.entity.Department;
import com.assignment.springbootassignment.entity.Employee;
import com.assignment.springbootassignment.service.DepartmentService;
import com.assignment.springbootassignment.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable Long empId){
        return employeeService.getEmployee(empId);
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody EmployeeDto employee){

        Department department=departmentService.getDepartment(employee.getDepartmentId());

        Employee employee1=new Employee();
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpDesn(employee.getEmpDesn());
        employee1.setDepartment(department);
        return employeeService.addEmployee(employee1);
    }

    @PutMapping("/{empId}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long empId){
        return employeeService.updateEmployee(employee, empId);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String empId){
        try{
            employeeService.deleteEmployee(Long.parseLong(empId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
