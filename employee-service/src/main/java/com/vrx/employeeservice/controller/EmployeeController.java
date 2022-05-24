package com.vrx.employeeservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrx.employeeservice.dto.EmployeeDto;
import com.vrx.employeeservice.entity.Employee;
import com.vrx.employeeservice.exception.EmployeeServiceException;
import com.vrx.employeeservice.service.EmployeeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee-service/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// Retrieve all data of employees
	@GetMapping("/employees")
	public List<EmployeeDto> getAllEmployees(){
		return employeeService.getAllEmployees();	
	}
	
	//Retrieve data of employee based on his/her id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") int id) throws EmployeeServiceException{
		return employeeService.getEmployeeById(id);
	}
	
	//Insert record for an employee
	@PostMapping("/employees")
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
		System.out.println(employeeDto);
		return employeeService.createEmployee(employeeDto);	
	}

	//Update record of an employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id")int id, @RequestBody EmployeeDto dto)
			throws EmployeeServiceException{
		return employeeService.updateEmployee(id,dto);
	}
	
	//Delete record of an Employee
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int id) throws EmployeeServiceException{
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		return employeeService.deleteEmployee(id);
	}
}
