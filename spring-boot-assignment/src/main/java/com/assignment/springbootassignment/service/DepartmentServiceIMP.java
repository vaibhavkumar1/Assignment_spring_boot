package com.assignment.springbootassignment.service;

import com.assignment.springbootassignment.entity.Department;
import com.assignment.springbootassignment.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceIMP implements DepartmentService{
    @Autowired
    private DepartmentRepo departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(long id) {
        Department entity = departmentRepository.getById(id);
        departmentRepository.delete(entity);
    }
}
