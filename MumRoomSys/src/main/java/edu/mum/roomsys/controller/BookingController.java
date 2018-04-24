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

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.dto.RoomSearchCriteria;
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
		return "index";
	}
	
	@RequestMapping(path = "/bookings/search/{page}", method = {RequestMethod.POST})
	public String search(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {	
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.search(searchCriteria, pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchType", "student");
		return "index";
	}			
	
	@RequestMapping(path = "/bookings/search/{page}", method = {RequestMethod.GET})
	public String searchGet(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {	
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.search(searchCriteria, pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchType", "student");		
		return "index";
	}		
	
	@RequestMapping(path = "/bookings/search/status/{page}", method = {RequestMethod.POST})
	public String searchByStatus(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.searchByStatus(searchCriteria, pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchType", "status");				
		return "index";
	}			

	@RequestMapping(path = "/bookings/search/status/{page}", method = {RequestMethod.GET})
	public String searchByStatusGet(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.searchByStatus(searchCriteria, pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchType", "status");			
		return "index";
	}		
	
	@RequestMapping(path = "/bookings/search/building/{page}", method = {RequestMethod.POST})
	public String searchByBuilding(@PathVariable("page") int pageNo, @Valid RoomSearchCriteria searchCriteria, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.searchByBuilding(searchCriteria, pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchType", "building");					
		return "index";
	}			
	
	@RequestMapping(path = "/bookings/search/building/{page}", method = { RequestMethod.GET})
	public String searchByBuildingGet(@PathVariable("page") int pageNo, @Valid RoomSearchCriteria searchCriteria, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("mainPage", "bookingList.jsp");
		Page<Booking> currentPage = bookingService.searchByBuilding(searchCriteria, pageNo, pageSize);
		model.addAttribute("bookings", currentPage);
		model.addAttribute("page", bookingService.getPage(currentPage, pageNo));
		model.addAttribute("searchType", "building");				
		return "index";
	}			
	
	@ModelAttribute
	public void addCommonAttributes(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());		
		model.addAttribute("roomSearchCriteria", new RoomSearchCriteria());
	}
}
