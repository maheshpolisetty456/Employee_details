package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	//method name query
	List<Employee> findByName(String name);
	//Custom Query
	@Query("select e from Employee e where e.salary = :salary")
	List<Employee> findEmployeeWithSalaryGreaterthan(@Param("salary") double salary);

}
