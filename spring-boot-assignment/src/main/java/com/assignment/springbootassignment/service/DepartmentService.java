package com.assignment.springbootassignment.service;

import com.assignment.springbootassignment.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getDepartments();

    public Department getDepartment(long id);

    public Department addDepartment(Department department);

    public Department updateDepartment(Department department);

    public void deleteDepartment(long id);
}
