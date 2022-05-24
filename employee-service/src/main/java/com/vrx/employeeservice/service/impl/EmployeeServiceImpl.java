package com.vrx.employeeservice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.vrx.employeeservice.dto.EmployeeDto;
import com.vrx.employeeservice.entity.Employee;
import com.vrx.employeeservice.exception.EmployeeServiceException;
import com.vrx.employeeservice.exception.ResourceNotFoundException;
import com.vrx.employeeservice.repository.EmployeeRepository;
import com.vrx.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		List<EmployeeDto> dtoEmployees = new ArrayList<>();
		employees.stream().forEach(e -> dtoEmployees.add(modelMapper.map(e, EmployeeDto.class)));
		return dtoEmployees;
	}

	@Override
	public ResponseEntity<Object> getEmployeeById(int id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		return ResponseEntity.ok().body(employeeDto);
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee = modelMapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
		return employeeDto;
	}

	@Override
	public ResponseEntity<Object> updateEmployee(int id, EmployeeDto dto) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employeeRepository.save(employee);
		return ResponseEntity.ok().body(dto);
	}

	@Override
	public Map<String, Boolean> deleteEmployee(int id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		employeeRepository.delete(employee);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("Employee deleted successfully", Boolean.TRUE);
		return map;
	}

}
