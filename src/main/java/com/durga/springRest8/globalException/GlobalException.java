package com.durga.springRest8.globalException;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.durga.springRest8.exception.StudentAlreadyFound;
import com.durga.springRest8.exception.StudentNotFound;

@ControllerAdvice
public class GlobalException {
	public static final Logger LOGGER=LoggerFactory.getLogger(GlobalException.class);
	@ExceptionHandler(exception= {StudentNotFound.class,StudentAlreadyFound.class})
	public ResponseEntity<Object> exception(Exception e){
		
		Map<String,String> error=new HashMap<String,String>();
		LOGGER.error("Student Details already existed: "+e.getMessage());
		error.put("message",e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
