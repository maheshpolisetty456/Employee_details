package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.DTO.EmployeeRequest;
import com.example.demo.DTO.EmployeeResponce;
import com.example.demo.DTO.Food;
import com.example.demo.Entity.Employee;

public interface EmployeeService {
	
	EmployeeResponce createEmployee(EmployeeRequest emp);
	List<Employee> LisgetAllEmployeels();
	EmployeeResponce getEmployeeById(Long id);
	EmployeeResponce updateEmployee (Long id, EmployeeRequest emp);
	void deleteEmployee(Long id);
//	Page<Employee> getEmployee(Pageable pageable);
	Page<Employee> getEmployee(int page, int size);
	List<EmployeeResponce> getEmployeeByName(String name);
	List<EmployeeResponce> getEmployeeWithSalary(double salary);
	
	Food getFoodDetails(Long id);
	Food getFoodWeb(Long Id);
	
}
