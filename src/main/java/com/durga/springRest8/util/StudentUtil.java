package com.durga.springRest8.util;

import com.durga.springRest8.beans.Student;
import com.durga.springRest8.dto.StudentDto;

public class StudentUtil {

	
	public static StudentDto getDto(Student std) {
		
		return new StudentDto(std.getSid(),std.getSname(),std.getSqual());	
	}
	
	public static Student getStudent(StudentDto dto) {
		return new Student(dto.getSid(),dto.getSname(),dto.getSqual());
	}
}
