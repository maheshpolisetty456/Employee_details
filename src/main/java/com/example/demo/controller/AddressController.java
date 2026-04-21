package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AddressRequest;
import com.example.demo.DTO.AddressResponce;
import com.example.demo.service.AddressService;

@RestController
public class AddressController {

	private final AddressService addressService;
	public AddressController (AddressService addressService) {
		this.addressService=addressService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<AddressResponce> createAddress(@RequestBody AddressRequest request){
		AddressResponce responce =  addressService.createAddress(request);
		return new ResponseEntity<>(responce,HttpStatus.OK);
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<AddressResponce> getByIdAddress(@PathVariable Long id){
		AddressResponce responce=  addressService.getAddreeById(id);
		return new ResponseEntity<>(responce,HttpStatus.OK);
	}
	
}
