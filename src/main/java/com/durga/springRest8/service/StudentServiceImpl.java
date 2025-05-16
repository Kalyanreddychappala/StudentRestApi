package com.durga.springRest8.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durga.springRest8.beans.Student;
import com.durga.springRest8.dao.StudentDao;
import com.durga.springRest8.dto.StudentDto;
import com.durga.springRest8.exception.StudentAlreadyFound;
import com.durga.springRest8.exception.StudentNotFound;
import com.durga.springRest8.util.StudentUtil;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao dao;
	@Override
	public StudentDto add(StudentDto dto) throws StudentAlreadyFound {
		if(dao.findById(dto.getSid()).isPresent()) {
			throw new StudentAlreadyFound("Student already existed: "+dto.getSid());
		}
		Student std=StudentUtil.getStudent(dto);
		Student save=dao.save(std);
		return StudentUtil.getDto(save);
	}

	@Override
	public StudentDto update(int sid, StudentDto dto) throws StudentNotFound {
		if(dao.findById(sid).isEmpty()) {
			throw new StudentNotFound("Student not existed: "+sid);
		}
		Student std=StudentUtil.getStudent(dto);
		Student save=dao.save(std);
		return StudentUtil.getDto(save);
	}

	@Override
	public StudentDto search(int sid) throws StudentNotFound {
		if(dao.findById(sid).isEmpty()) {
			throw new StudentNotFound("Student not existed: "+sid);
		}
		Student get=dao.findById(sid).get();
		return StudentUtil.getDto(get);
	}

	@Override
	public List<StudentDto> searchAll() throws StudentNotFound {
		if(dao.findAll().isEmpty()) {
			throw new StudentNotFound("Students not existed: ");
		}
		List<Student> getAll=dao.findAll();
		return getAll.stream()
				.map(StudentUtil::getDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(int sid) throws StudentNotFound {
		if(dao.findById(sid).isEmpty()) {
			throw new StudentNotFound("Student not existed: "+sid);
		}
		dao.deleteById(sid);
		
	}

}
