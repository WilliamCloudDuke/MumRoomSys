package edu.mum.roomsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Value("${page.size}")
	private int pageSize;
	
	@GetMapping({"/students/{page}"})
	public String getAllStudents(@PathVariable("page") int pageNo, Model model) {
		model.addAttribute("mainPage", "studentList.jsp");
		Page<Student> currentPage = studentService.findAll(pageNo, pageSize);
		model.addAttribute("students", currentPage);
		model.addAttribute("page", studentService.getPage(currentPage, pageNo));
		return "index";
	}
	
	
	
}
