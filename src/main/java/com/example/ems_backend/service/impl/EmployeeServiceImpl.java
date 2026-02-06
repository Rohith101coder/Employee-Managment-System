package com.example.ems_backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exception.ResourceNotFoundException;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
       
        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long id) {
        
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee is not exsist with given id:"+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> list=employeeRepository.findAll();
       List<EmployeeDto> listdto=new ArrayList<>();
       for(int i=0;i<list.size();i++){
        listdto.add(EmployeeMapper.mapToEmployeeDto(list.get(i)));
       }
       return listdto;
    }
    @Override
    public EmployeeDto updateEmployeeById(Long empId,EmployeeDto employeeDto) {
       Employee employee=employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("User not found"));
       employee.setFirstName(employeeDto.getFirstName());
       employee.setLastName(employeeDto.getLastName());
       employee.setEmail(employeeDto.getEmail());
       Employee updatedEmployee=employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }
    @Override
    public void deleteEmployee(Long empId) {
        // Employee employee=employeeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee is not exsist with given id:"+empId));
        employeeRepository.deleteById(empId);
    }


    
    
    


}
