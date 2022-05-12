package com.assignment.springbootassignment.dto;

import com.assignment.springbootassignment.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String empName;
    private String empDesn;

    private Long departmentId;
}
