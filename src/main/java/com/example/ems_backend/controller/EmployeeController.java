package com.example.ems_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems_backend.dto.EmployeeDto;

import com.example.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto),HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getSpecificEmployee(@PathVariable("id") Long id){
       EmployeeDto employeeDto=employeeService.getEmployeeById(id);
       return ResponseEntity.ok(employeeDto);
    }
}
