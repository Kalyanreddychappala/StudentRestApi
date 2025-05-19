package com.durga.springRest8.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.durga.springRest8.dto.StudentDto;
import com.durga.springRest8.exception.StudentAlreadyFound;
import com.durga.springRest8.exception.StudentNotFound;
import com.durga.springRest8.service.StudentService;

@RestController
public class StudentController {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(StudentController.class);
	@Autowired
	public StudentService service;

	@PostMapping("/students")
	public ResponseEntity<Object> add(@RequestBody StudentDto dto) throws StudentAlreadyFound {

		StudentDto result = service.add(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);

	}

	@PutMapping("/students/{sid}")
	public ResponseEntity<Object> update(@PathVariable int sid, @RequestBody StudentDto dto) throws StudentNotFound {
		StudentDto result = service.update(sid, dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);

	}
	@GetMapping("/get/{sid}")
	public ResponseEntity<Object> get(@PathVariable int sid) throws StudentNotFound {
		StudentDto result = service.search(sid);
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll() throws StudentNotFound {
		List<StudentDto> result = service.searchAll();
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}
	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<Object> delete(@PathVariable int sid) throws StudentNotFound {
	 service.delete(sid);
		return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");

	}
	
	
	

}
