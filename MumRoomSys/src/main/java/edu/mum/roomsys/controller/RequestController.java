package edu.mum.roomsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.roomsys.domain.Request;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.RequestService;

@Controller
public class RequestController {
	@Autowired
	private RequestService requestService;
	
	@Value("${page.size}")
	private int pageSize;
	
	
	
	@GetMapping({"/requests/{page}"})
	public String getStudentById(@PathVariable("page") int pageNo, Model model) {
		model.addAttribute("mainPage", "request.jsp");
		Page<Request> currentPage = requestService.findAll(pageNo, pageSize);
		model.addAttribute("requests", currentPage);
		model.addAttribute("page", requestService.getPage(currentPage, pageNo));
		return "request";
		
		
	}

}
