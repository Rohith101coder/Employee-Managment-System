package com.example.ems_backend.service;

import java.util.List;

import com.example.ems_backend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployeeById(Long empId,EmployeeDto employeeDto);

    void deleteEmployee(Long empId);
}
