package edu.mum.roomsys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.SearchCriteria;
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
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "index";
	}	
	
	@RequestMapping(path = "/students/search/{page}", method = {RequestMethod.POST,  RequestMethod.GET})
	public String search(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {			
		model.addAttribute("mainPage", "studentList.jsp");
		Page<Student> currentPage = studentService.search(searchCriteria, pageNo, pageSize);
		model.addAttribute("students", currentPage);
		model.addAttribute("page", studentService.getPage(currentPage, pageNo));
		model.addAttribute("searchCriteria", searchCriteria);
		return "index";
	}		
	
	@RequestMapping(path = {"/student/detail"}, method = {RequestMethod.GET})
	public String getStudentForCreate(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("mainPage", "studentDetail.jsp");	
		return "index";
	}	
	
	@RequestMapping(path = {"/student/{id}"}, method = {RequestMethod.GET})
	public String getStudentForEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		model.addAttribute("mainPage", "studentEdit.jsp");	
		return "index";
	}
	
	@RequestMapping(path = {"/student/create"}, method = {RequestMethod.POST})
	public String createStudent(@Valid Student student, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("student", student);
			model.addAttribute("mainPage", "studentDetail.jsp");	
			return "index";
		}
		
		studentService.createStudent(student);
		
		return "redirect:/students/0";
	}	
	
	@RequestMapping(path = {"/student/edit/{id}"}, method = {RequestMethod.POST})
	public String updateStudent(@Valid Student student, BindingResult bindingResult, Model model) {		
		studentService.editStudent(student);
		return "redirect:/students/0";
	}	
	
	@RequestMapping(path = {"/student/resetpass/{id}"}, method = {RequestMethod.POST})
	public String resetPassStudent(Student student, BindingResult bindingResult, Model model) {		
		studentService.resetPassword(student);
		return "redirect:/students/0";
	}		
	
	@RequestMapping(path = {"/student/enable/{id}"}, method = {RequestMethod.POST})
	public String enableStudent(Student student, BindingResult bindingResult, Model model) {		
		studentService.enable(student);
		return "redirect:/students/0";
	}		
	
	@RequestMapping(path = {"/student/delete/{id}"}, method = {RequestMethod.POST})
	public String deleteStudent(Student student, BindingResult bindingResult, Model model) {		
		studentService.delete(student);
		return "redirect:/students/0";
	}			
}
