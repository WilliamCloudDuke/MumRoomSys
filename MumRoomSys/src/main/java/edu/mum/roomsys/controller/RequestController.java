package edu.mum.roomsys.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.Request;
import edu.mum.roomsys.domain.RequestType;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.RequestSearchCriteria;
import edu.mum.roomsys.dto.RoomSearchCriteria;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.RequestService;
import edu.mum.roomsys.service.AccountService;

@Controller
public class RequestController {
	@Autowired
	private RequestService requestService;
		
	@Value("${page.size}")
	private int pageSize;
	
	@RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/index";
    }
	
	@ModelAttribute
	public void defaultModel(Model model) {
		model.addAttribute("request", new Request());		
	}
	
	//differentiate users authority as student and admin role
	@GetMapping("/requests/{page}")
	public String requestHome(@PathVariable("page") int pageNo,Model model) {
		Authentication authorization= SecurityContextHolder.getContext().getAuthentication();
		Account account = requestService.findByUsername(authorization.getName());
		
		boolean hasAdminRole = authorization.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("DIRECTOR"));
		
		//for admin role
		if (hasAdminRole) {	
				Page<Request> currentPage = requestService.findAll(pageNo, pageSize);
				model.addAttribute("mainPage", "adminRequest.jsp");
				model.addAttribute("requests", currentPage);
				model.addAttribute("page", requestService.getPage(currentPage, pageNo));
				model.addAttribute("searchCriteria",new SearchCriteria() );
				return "index";
		}
		
		//for student role 
		Student student1=account.getStudent();
		Page<Request> currentPage = requestService.findByStudent(student1,pageNo, pageSize);
		model.addAttribute("requests", currentPage);
		model.addAttribute("searchCriteria",new SearchCriteria() );
		model.addAttribute("mainPage", "studentRequest.jsp");
			return "index";
		
			
	}		
	
	
	//mapping for creating new request
	@RequestMapping(path = "/request/creatrequest", method = {RequestMethod.POST})
	public String creatrequest(Request request, BindingResult bindingResult, Model model) {	
		Authentication authorization= SecurityContextHolder.getContext().getAuthentication();
		Account account = requestService.findByUsername(authorization.getName());
		requestService.createRequest(request.getType(),request.getDescription(),account.getStudent());
		
	    Page<Request> currentPage = requestService.findByStudent(account.getStudent(),0, pageSize);
	    model.addAttribute("requests", currentPage);
		model.addAttribute("searchCriteria",new SearchCriteria() );
		
		model.addAttribute("mainPage", "studentRequest.jsp");
		return "index";
	}	

	
	
	
	
			
		
	
	@GetMapping({"/request/{page}"})
	public String getAllRequests(@PathVariable("page") int pageNo, Model model) {
		model.addAttribute("mainPage", "request.jsp");
		Page<Request> currentPage = requestService.findAll(pageNo, pageSize);
		model.addAttribute("requests", currentPage);
		model.addAttribute("page", requestService.getPage(currentPage, pageNo));
		model.addAttribute("searchCriteria",new SearchCriteria() );
		return "index";
		}
	
		
	/*@RequestMapping(path = "/request/search/requestType/{page}", method = {RequestMethod.POST, RequestMethod.GET})
	public String searchByType(@PathVariable("page") int pageNo, @Valid RequestSearchCriteria searchCriteria, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("mainPage", "request.jsp");
		Page<Request> currentPage = requestService.searchByType(searchCriteria.getType(), pageNo, pageSize);
		model.addAttribute("requests", currentPage);
		model.addAttribute("page", requestService.getPage(currentPage, pageNo));
		model.addAttribute("requestSearchCriteria", searchCriteria);		
		return "index";
	}		*/
	
	
	
	
@RequestMapping(path = "/request/selectRequest/{page}", method = {RequestMethod.POST})
public String selectRequest(@PathVariable("page") int pageNo,Request request, BindingResult bindingResult, Model model) {
	
	Authentication auth= SecurityContextHolder.getContext().getAuthentication();
	String discription=request.getDescription();
	model.addAttribute("ListDisplay", discription);
	if(discription=="BY REQUEST TYPE")
		System.out.println("BY REQUEST TYPE");
	if(discription=="BY BUILDING")
		System.out.println("BY BUILDING");
	if(discription=="BY REQUEST TYPE")
		System.out.println("BY STUDENT");
	//Account account = requestService.findByUsername(auth.getName());
	
	model.addAttribute("mainPage", "selectRequest.jsp");
		return "index";
}
}








