package com.durga.springRest8.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
public class StudentNotFound extends Exception{
	
	public String message;

}
