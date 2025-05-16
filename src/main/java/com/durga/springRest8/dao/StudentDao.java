package com.durga.springRest8.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durga.springRest8.beans.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}
