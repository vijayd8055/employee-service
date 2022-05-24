package com.vrx.employeeservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.vrx.employeeservice.dto.EmployeeDto;
import com.vrx.employeeservice.exception.ResourceNotFoundException;

public interface EmployeeService {

	List<EmployeeDto> getAllEmployees();

	ResponseEntity<Object> getEmployeeById(int id) throws ResourceNotFoundException;

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	ResponseEntity<Object> updateEmployee(int id, EmployeeDto dto) throws ResourceNotFoundException;

	Map<String, Boolean> deleteEmployee(int id) throws ResourceNotFoundException;


}
