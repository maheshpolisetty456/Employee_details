package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	List<Address> findByState(String state);
	@Query("Select e from Address e where e.city=:city")
	List<Address> getCityFromAddress(@Param("city") String city);
	
	

}
