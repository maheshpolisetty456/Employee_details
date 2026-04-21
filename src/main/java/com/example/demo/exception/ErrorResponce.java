package com.example.demo.exception;

import java.time.LocalDateTime;

public class ErrorResponce {
	private String message;
	private int status;
	private LocalDateTime datetime;
	
	public ErrorResponce(){
		
	}
	public ErrorResponce (String message, int status, LocalDateTime dateTime) {
		this.message=message;
		this.status=status;
		this.datetime=dateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	

}
