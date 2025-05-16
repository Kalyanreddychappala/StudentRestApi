package com.durga.springRest8.service;

import java.util.List;

import com.durga.springRest8.dto.StudentDto;
import com.durga.springRest8.exception.StudentAlreadyFound;
import com.durga.springRest8.exception.StudentNotFound;

public interface StudentService {
	
	public StudentDto add(StudentDto dto) throws StudentAlreadyFound;
	public StudentDto update(int sid,StudentDto dto) throws StudentNotFound;
	public StudentDto search(int sid) throws StudentNotFound;
	public List<StudentDto> searchAll() throws StudentNotFound;
	public void delete(int sid) throws StudentNotFound;

}
