package edu.mum.roomsys.rest;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.StudentDto;
import edu.mum.roomsys.service.StudentService;

@Controller
public class StudentServiceController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = { "/api/students" }, method = { RequestMethod.GET })
	@ResponseBody
	public Iterable<Student> getStudents() {
		return studentService.findAll();
	}

	@RequestMapping(value = { "/api/students" }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public StudentDto createStudent(@RequestBody StudentDto studentDto) throws ParseException {
        Student student = convertToEntity(studentDto);
        Student studentCreated = studentService.createStudentProfile(student);
        return convertToDto(studentCreated);
    }

	private StudentDto convertToDto(Student student) {
		return modelMapper.map(student, StudentDto.class);
	}	
	
	private Student convertToEntity(StudentDto studentDto) throws ParseException {
		return modelMapper.map(studentDto, Student.class);
	}	
	
}
