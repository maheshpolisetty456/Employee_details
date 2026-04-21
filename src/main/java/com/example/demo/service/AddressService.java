package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.AddressRequest;
import com.example.demo.DTO.AddressResponce;
import com.example.demo.Entity.Address;

public interface AddressService {

	AddressResponce createAddress(AddressRequest request);
	AddressResponce getAddreeById(Long id);
	List<AddressResponce> getAllAddressById();
	AddressResponce updateAddress(Long id, AddressRequest request);
	void deleteAddressById(Long id);
	List<AddressResponce> getAddressByState(String state);
	List<AddressResponce> getCityFromAddress(String city);
	
	
}
