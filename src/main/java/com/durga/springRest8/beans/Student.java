package com.durga.springRest8.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student")

public class Student {
	@Id
	private int sid;
	private String sname;
	private String squal;
	
	

}
