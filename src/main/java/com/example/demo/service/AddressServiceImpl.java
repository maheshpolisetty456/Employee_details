package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AddressRequest;
import com.example.demo.DTO.AddressResponce;
import com.example.demo.Entity.Address;
import com.example.demo.exception.AddressResorceNotFoundException;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	private final AddressRepository repository;
	public AddressServiceImpl (AddressRepository repository) {
		this.repository=repository;
	}

	@Override
	public AddressResponce createAddress(AddressRequest request) {
		
		Address address = new Address();
		
		address.setState(request.getState());
		address.setCity(request.getCity());
		address.setPincode(request.getPincode());
		
		Address saved = repository.save(address);
		
		return mapToResponce(saved);
	}

	@Override
	public AddressResponce getAddreeById(Long id) {
		Address address = repository.findById(id).orElseThrow(()->new AddressResorceNotFoundException("Addresss Not found: "+id));
		return mapToResponce(address);
	}

	@Override
	public List<AddressResponce> getAllAddressById() {
		List<Address> address = repository.findAll();
		
		return address.stream().map(this::mapToResponce).toList();
	}

	@Override
	public AddressResponce updateAddress(Long id, AddressRequest request) {
		Address address = repository.findById(id).orElseThrow(()->new AddressResorceNotFoundException( "Address not Found: "+id));
		
		address.setCity(request.getCity());
		address.setState(request.getState());
		address.setPincode(request.getPincode());
		
		Address saved = repository.save(address);
		
		return mapToResponce(saved);
	}

	@Override
	public void deleteAddressById(Long id) {
	    Address address = repository.findById(id).orElseThrow(()->new AddressResorceNotFoundException("Address not found Exception: "+id));
	    repository.delete(address);
		
	}
	
	public AddressResponce mapToResponce(Address address) {
		AddressResponce responce = new AddressResponce();
		
		responce.setId(address.getId());
		responce.setState(address.getState());
		responce.setCity(address.getCity());
		responce.setPincode(address.getPincode());
		return responce;
	}

	@Override
	public List<AddressResponce> getAddressByState(String state) {
		List<Address> address = repository.findByState(state);
		return address.stream().map(this::mapToResponce).toList();
	}

	@Override
	public List<AddressResponce> getCityFromAddress(String city) {
		List<Address> address = repository.getCityFromAddress(city);
		return address.stream().map(this::mapToResponce).toList();
	}

}
