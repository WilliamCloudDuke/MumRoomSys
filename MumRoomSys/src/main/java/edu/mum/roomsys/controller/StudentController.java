package edu.mum.roomsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.mum.roomsys.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Value("${page.size}")
	private int pageSize;
	
	@GetMapping({"/students/{page}"})
	public String getAllStudents(@PathVariable("page") int page, Model model) {
		model.addAttribute("mainPage", "studentList.jsp");
		model.addAttribute("students", studentService.findAll(page, pageSize));
		return "index";
	}
}
