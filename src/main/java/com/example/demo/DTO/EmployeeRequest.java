package com.example.demo.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class EmployeeRequest {

	@NotBlank(message = "Name cannot be entry")
	@Size(min =3, max=20)
	private String name;
	
	@NotEmpty(message = "Department required")
	private String department;
	
	@Min(value = 10000)
	@Max(value = 100000)
	private double salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department=department;
	}
	public double getSalary() {
		return salary=salary;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	
}
