package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DTO.EmployeeRequest;
import com.example.demo.DTO.EmployeeResponce;
import com.example.demo.DTO.Food;
import com.example.demo.Entity.Employee;
import com.example.demo.exception.ResourcesNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceIMPL (EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Autowired
	public RestTemplate restTemplate;

	public WebClient webClient;
	@Override
	public EmployeeResponce createEmployee(EmployeeRequest request) {
		
		Employee emp = new Employee();
		
		emp.setName(request.getName());
		emp.setDepartment(request.getDepartment());
		emp.setSalary(request.getSalary());
		
		Employee savedEmp = employeeRepository.save(emp);
		

		
		
		return mapToResponce(savedEmp);
	}

	@Override
	public List<Employee> LisgetAllEmployeels() {
		
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeResponce getEmployeeById(Long id) {
		Employee savedemp = employeeRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Employee is not exist"+id));
		
//		EmployeeResponce responce = new EmployeeResponce();
//		responce.setId(savedemp.getId());
//		responce.setName(savedemp.getName());
//		responce.setDepartment(savedemp.getDepartment());
//		responce.setSalary(savedemp.getSalary());
		
		
		return mapToResponce(savedemp);
	}

	@Override
	public EmployeeResponce updateEmployee(Long id, EmployeeRequest request) {
		Employee update =employeeRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Employee is not exist:"+id));
		
		update.setName(request.getName());
		update.setDepartment(request.getDepartment());
		update.setSalary(request.getSalary());
		
		Employee savedEmployee = employeeRepository.save(update);
		
//		EmployeeResponce responce = new EmployeeResponce();
		
//		responce.setId(savedEmployee.getId());
//		responce.setName(savedEmployee.getName());
//		responce.setDepartment(savedEmployee.getDepartment());
//		responce.setSalary(savedEmployee.getSalary());
		
		return mapToResponce(savedEmployee);
		
		
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee delete = employeeRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Employee is not exist:"+id));
		
		employeeRepository.delete(delete);
		
	}

	@Override
	public Page<Employee> getEmployee(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return employeeRepository.findAll(pageable);
	}

//	@Override
//	public Page<Employee> getEmployee(Pageable pageable) {
//		
//		return employeeRepository.findAll(pageable);
//	}
	
	public EmployeeResponce mapToResponce(Employee emp) {
		
		EmployeeResponce responce = new EmployeeResponce();
		responce.setId(emp.getId());
		responce.setName(emp.getName());
		responce.setDepartment(emp.getDepartment());
		responce.setSalary(emp.getSalary());
		return responce;
		
	}

//	@Override
//	public List<EmployeeResponce> getEmployeeByName(String name) {
//		List<Employee> employee = employeeRepository.findByName(name);
//		 return employee.stream().map(this::mapToResponce).toList();
//	}

	@Override
	public List<EmployeeResponce> getEmployeeWithSalary(double salary) {
		List<Employee> saved = employeeRepository.findEmployeeWithSalaryGreaterthan(salary);
		return saved.stream().map(this::mapToResponce).toList();
	}

	@Override
	public List<EmployeeResponce> getEmployeeByName(String name) {
		List<Employee> employee = employeeRepository.findByName(name);
		 return employee.stream().map(this::mapToResponce).toList();
		
	}

	@Override
	public Food getFoodDetails(Long id) {
		String url = "http://localhost:9092/get/2";
		 Food food = restTemplate.getForObject(url,Food.class);
		return food;
	}

	@Override
	public Food getFoodWeb(Long Id) {
		
		return webClient.get().uri("http://localhost:9092/get/2").retrieve().bodyToMono(Food.class).block();
	}

//@Override
//public List<EmployeeResponce> getEmployeeByName(String name) {
//	List<Employee> employee = employeeRepository.findByName(name);
//	return employee.stream().map(this::mapToResponce).toList();
//}
	

}
