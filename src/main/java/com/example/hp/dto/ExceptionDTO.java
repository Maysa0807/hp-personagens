package com.example.hp.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class ExceptionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer status;
	
	public ExceptionDTO(String message, Integer status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	
}
