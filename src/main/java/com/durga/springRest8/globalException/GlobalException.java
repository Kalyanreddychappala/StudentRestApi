package com.durga.springRest8.globalException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.durga.springRest8.exception.StudentAlreadyFound;
import com.durga.springRest8.exception.StudentNotFound;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(exception= {StudentNotFound.class,StudentAlreadyFound.class})
	public ResponseEntity<Object> exception(Exception e){
		
		Map<String,String> error=new HashMap<String,String>();
		error.put("message",e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
