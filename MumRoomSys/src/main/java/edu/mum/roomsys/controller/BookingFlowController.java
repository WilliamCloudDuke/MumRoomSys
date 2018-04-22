package edu.mum.roomsys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;
import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.RoomSearchCriteria;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.BookingService;

@Controller
public class BookingFlowController {
	
	@Autowired
	private BookingService bookingService;
	
	@Value("${page.size}")
	private int pageSize;	
	
	public Booking createBooking() {
		Booking booking = new Booking();
		booking.setStatus(BookingStatus.NEW);
		return booking;
	}
	
	@ModelAttribute
	public void addCommonAttributes(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());		
		model.addAttribute("roomSearchCriteria", new RoomSearchCriteria());
	}	
	
	@RequestMapping(path = "/bookings/students/{page}", method = {RequestMethod.POST})
	public String searchStudent(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {
		model.addAttribute("mainPage", "bookingStudentList.jsp");
		Page<Student> currentPage = bookingService.searchByStudent(searchCriteria, pageNo, pageSize);
		model.addAttribute("students", currentPage);
		model.addAttribute("page", bookingService.getPageStudent(currentPage, pageNo));
		return "index";
	}	
	
	@RequestMapping(path = "/bookings/students/{page}", method = {RequestMethod.GET})
	public String searchStudentGet(@PathVariable("page") int pageNo, SearchCriteria searchCriteria, Model model) {
		model.addAttribute("mainPage", "bookingStudentList.jsp");
		Page<Student> currentPage = bookingService.searchByStudent(searchCriteria, pageNo, pageSize);
		model.addAttribute("students", currentPage);
		model.addAttribute("page", bookingService.getPageStudent(currentPage, pageNo));
		return "index";
	}				
	
	@RequestMapping(path = "/bookings/rooms/number/{page}", method = {RequestMethod.POST})
	public String searchByBuilding(@PathVariable("page") int pageNo, @Valid RoomSearchCriteria searchCriteria, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("mainPage", "bookingRoomList.jsp");
		Page<Room> currentPage = bookingService.searchByRoomNumber(searchCriteria, pageNo, pageSize);
		model.addAttribute("rooms", currentPage);
		model.addAttribute("searchType", "building");	
		model.addAttribute("page", bookingService.getPageRoom(currentPage, pageNo));	
		return "index";
	}		
	
	@RequestMapping(path = "/bookings/rooms/number/{page}", method = {RequestMethod.GET})
	public String searchByBuildingGet(@PathVariable("page") int pageNo, @Valid RoomSearchCriteria searchCriteria, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("mainPage", "bookingRoomList.jsp");
		Page<Room> currentPage = bookingService.searchByRoomNumber(searchCriteria, pageNo, pageSize);
		model.addAttribute("rooms", currentPage);
		model.addAttribute("searchType", "building");	
		model.addAttribute("page", bookingService.getPageRoom(currentPage, pageNo));
		return "index";
	}			
	
	@RequestMapping(path = "/bookings/rooms/status/{page}", method = {RequestMethod.POST})
	public String searchByStatus(@PathVariable("page") int pageNo, @Valid RoomSearchCriteria searchCriteria, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("mainPage", "bookingRoomList.jsp");
		Page<Room> currentPage = bookingService.searchByRoomStatus(searchCriteria, pageNo, pageSize);
		model.addAttribute("rooms", currentPage);
		model.addAttribute("searchType", "status");			
		model.addAttribute("page", bookingService.getPageRoom(currentPage, pageNo));	
		return "index";
	}			

	@RequestMapping(path = "/bookings/rooms/status/{page}", method = {RequestMethod.GET})
	public String searchByStatusGet(@PathVariable("page") int pageNo, @Valid RoomSearchCriteria searchCriteria, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("mainPage", "bookingRoomList.jsp");
		Page<Room> currentPage = bookingService.searchByRoomStatus(searchCriteria, pageNo, pageSize);
		model.addAttribute("rooms", currentPage);
		model.addAttribute("searchType", "status");			
		model.addAttribute("page", bookingService.getPageRoom(currentPage, pageNo));	
		return "index";
	}			
}
