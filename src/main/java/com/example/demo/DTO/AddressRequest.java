package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class AddressRequest {

	@NotBlank(message = "state should not be empty")
	@Size(min=3, max = 10)
	private String state;
	
	@NotBlank(message = "city sould not be Blank")
	private String city;
	
	@NotBlank(message = "pincode should not be pincode")
	@Size(min=5,max=6)
	private int pincode;
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city= city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode=pincode;
	}
}
