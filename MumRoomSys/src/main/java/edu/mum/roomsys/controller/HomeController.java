package edu.mum.roomsys.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/index", "/admin"})
	public String homePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean hasAdminRole = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("DIRECTOR"));
		if (hasAdminRole) {
			model.addAttribute("mainPage", "admin_home.jsp");
			return "index";
		}
		
		model.addAttribute("mainPage", "student_home.jsp");
		return "student_index";
	}
	
	@GetMapping({"/loginpage"})
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/loginfailed", method=RequestMethod.GET)
	public String loginFailed(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}		
}
