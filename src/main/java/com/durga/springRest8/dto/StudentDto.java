package com.durga.springRest8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private int sid;
	private String sname;
	private String squal;

}
