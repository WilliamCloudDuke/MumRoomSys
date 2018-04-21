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

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.BookingService;

@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@Value("${page.size}")
	private int pageSize;	
	
	@GetMapping({"/bookings/{page}"})
	public String getAllBookings(@PathVariable("page") int pageNo, Model model) {
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.findAll(pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "index";
	}
	
	@RequestMapping(path = "/bookings/search/{page}", method = RequestMethod.POST)
	public String search(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.search(searchCriteria, pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "index";
	}			

}
