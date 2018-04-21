package edu.mum.roomsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.CheckinService;

public class CheckinController {

	@Autowired
	private CheckinService checkinService;

	@GetMapping({ "/checking/{studentId}" })
	public String getBookingNew(@PathVariable("studentId") int studentId, Model model) {
		model.addAttribute("mainPage", "studentCheckin.jsp");
		model.addAttribute("bookingNew", checkinService.findByStatusNewLike(studentId));
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "student_index";
	}

}
