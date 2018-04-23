package edu.mum.roomsys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.RoomSearchCriteria;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.BookingService;

@Controller
@SessionAttributes(value = {"selectedStudent", "selectedRoom", "currentBooking"})
public class BookingFlowController {
	
	@Autowired
	private BookingService bookingService;	
	
	@Value("${page.size}")
	private int pageSize;	
	
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
	
	@RequestMapping(path = "/bookings/students/select/{id}", method = {RequestMethod.GET})
	public String selectStudent(@PathVariable("id") int id, ModelMap model) {
		if (!model.containsAttribute("selectedStudent")) {
			model.addAttribute("selectedStudent", bookingService.findStudentById(id));
		}
		return "redirect:/bookings/rooms/status/0?roomStatus=READY";
	}	
	
	@RequestMapping(path = "/bookings/rooms/select/{id}", method = {RequestMethod.GET})
	public String selectRoom(@PathVariable("id") int id, ModelMap map) {
		if (!map.containsAttribute("selectedRoom")) {
			map.addAttribute("selectedRoom", bookingService.findRoomById(id));
		} 	
		
		Booking booking = bookingService.createBooking((Student)map.get("selectedStudent"), (Room)map.get("selectedRoom"));		

		if (!map.containsAttribute("currentBooking")) {
			map.addAttribute("currentBooking", booking);
		}		
		
		booking = (Booking)map.get("currentBooking");	
		map.addAttribute("booking", booking);
		map.addAttribute("mainPage", "bookingConfirmation.jsp");
		return "index";
	}	
	
	@RequestMapping(path = "/bookings/confirm", method = {RequestMethod.POST})
	public String selectRoom(@Valid Booking booking, BindingResult bindingResult, ModelMap map, SessionStatus sessionStatus) {
		if (bindingResult.hasErrors()) {	
			map.addAttribute("booking", map.get("currentBooking"));
			map.addAttribute("mainPage", "bookingConfirmation.jsp");
			return "index";
		}
	
		Booking currentBooking = (Booking)map.get("currentBooking");	
		currentBooking.setMoveInDate(booking.getMoveInDate());
		currentBooking.setMoveOutDate(booking.getMoveOutDate());
		
		bookingService.save(currentBooking);
		
		sessionStatus.setComplete();
		
		return "redirect:/bookings/search/status/0?bookingStatus=NEW";
	}					
	
	@RequestMapping(path = "/booking/delete/{id}", method = {RequestMethod.GET})
	public String deleteBooking(@PathVariable("id") int id) {
		try {
			bookingService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/bookings/search/status/0?bookingStatus=NEW";
	}		
	
}
