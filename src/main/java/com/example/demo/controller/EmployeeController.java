package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeRequest;
import com.example.demo.DTO.EmployeeResponce;
import com.example.demo.DTO.Food;
import com.example.demo.Entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	
	@PostMapping("/created")
	public ResponseEntity<EmployeeResponce> saveEmployee(@Valid @RequestBody EmployeeRequest  emp){
		EmployeeResponce saved = employeeService.createEmployee(emp);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	@GetMapping("/EmployeeId/{id}")
	public ResponseEntity<EmployeeResponce> getEmployeeById(@PathVariable Long id){
		EmployeeResponce getByid= employeeService.getEmployeeById(id);
		return new ResponseEntity<>(getByid,HttpStatus.OK);
	}
	
	@GetMapping("/AllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list = employeeService.LisgetAllEmployeels();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PutMapping("/updating/{id}")
	public ResponseEntity<EmployeeResponce> deleteEmployee(@PathVariable Long id,  @Valid @RequestBody EmployeeRequest emp){
		EmployeeResponce updating = employeeService.updateEmployee(id, emp);
		
		return new ResponseEntity<>(updating,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee detais are deleted",HttpStatus.OK);
	}
	
//	@GetMapping("/pagination")
//	public ResponseEntity<Page<Employee>> getEmployeePages(Pageable pageable){
//		return new ResponseEntity (employeeService.getEmployee(pageable),HttpStatus.OK);
//	}
	
	@GetMapping("/pagination")
	public ResponseEntity<Page<Employee>> getEmployeePages(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<>(employeeService.getEmployee(page, size),HttpStatus.OK);
	}
	
	
	//checking the global exception
	@GetMapping("null")
	public String getNull() {
		String name = null;
		name.length();
		return "Hell";
	}
	
	@GetMapping("number")
	public String getCheck() {
		int num = 10/0;
		return "Success";
	}
	
	@GetMapping("/Name/{name}")
	public ResponseEntity<List<EmployeeResponce>> getEmployeeName(@PathVariable String name){
		List<EmployeeResponce> saved = employeeService.getEmployeeByName(name);
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	@GetMapping("/salary")
	public ResponseEntity<List<EmployeeResponce>> getEmployeeWithSalary(@RequestParam double salary){
		List<EmployeeResponce> emp = employeeService.getEmployeeWithSalary(salary);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	@GetMapping("/food/{id}")
	public ResponseEntity<Food> getFood(@PathVariable Long id){
		 Food food = employeeService.getFoodDetails(id);
		 
		 return new ResponseEntity<>(food, HttpStatus.OK);
	}
	
	@GetMapping("/web/{id}")
	public ResponseEntity<Food> getFoodWeb(@PathVariable Long id){
		Food food = employeeService.getFoodWeb(id);
		return new ResponseEntity<>(food,HttpStatus.OK);
	}
	}
