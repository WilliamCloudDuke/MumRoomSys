package edu.mum.roomsys.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean hasAdminRole = auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"));
		if (hasAdminRole) {
			model.addAttribute("mainPage", "admin_home.jsp");
			return "index";
		}
		
		model.addAttribute("mainPage", "student_home.jsp");
		return "index";
	}
}
