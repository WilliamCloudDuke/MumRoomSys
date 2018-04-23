package edu.mum.roomsys.rest;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.service.StudentService;

@Controller
public class StudentServiceController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value= {"/api/students"}, method = {RequestMethod.GET})
	public @ResponseBody Iterable<Student> getStudents() {
		return studentService.findAll();
	}

}
