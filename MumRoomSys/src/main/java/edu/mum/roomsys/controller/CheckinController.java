package edu.mum.roomsys.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.domain.BookItem;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingItemType;
import edu.mum.roomsys.domain.BookingStatus;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.AccountService;
import edu.mum.roomsys.service.BookItemService;
import edu.mum.roomsys.service.BookingService;
import edu.mum.roomsys.service.CheckinService;

@Controller
public class CheckinController {

	@Autowired
	private CheckinService checkinService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private BookItemService bookItemService;

	@GetMapping({ "/student/checkin" })
	public String getBookingNew(Model model) {
		model.addAttribute("mainPage", "studentCheckin.jsp");
		Booking booking = checkinService.findByStatusNewLike(getStudentId());
		BookItem bookItem = booking.getCheckinRecord();
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckInDate(new Date());
		model.addAttribute("bookingNew", booking);
		model.addAttribute("bookingItemNew", bookItem);
		return "student_index";
	}

	@RequestMapping(path = { "/student/checkin/{id}" }, method = { RequestMethod.GET })
	public String getBookingForEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("mainPage", "studentCheckin.jsp");
		Booking booking = checkinService.findById(id);
		model.addAttribute("bookingNew", booking);
		BookItem bookItem = booking.getCheckinRecord();
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckInDate(new Date());
		model.addAttribute("bookingNew", booking);
		model.addAttribute("bookingItemNew", bookItem);
		return "student_index";
	}

	@RequestMapping(path = { "/student/checkin/add" }, method = { RequestMethod.POST })
	private String createCheckIn(@Valid BookItem bookItemToBeAdded, Model model) {
		// Booking bookingToBeUpdated = bookItemToBeAdded.getBooking();
		Booking bookingToBeUpdated = checkinService.findByStatusNewLike(getStudentId());
		bookingToBeUpdated.setStatus(BookingStatus.CHECKED_IN);
		bookingToBeUpdated.setMoveInDate(bookItemToBeAdded.getCheckInDate());
		bookingService.setStatusAndMoveInDate(bookingToBeUpdated);
		bookItemToBeAdded.setBooking(bookingToBeUpdated);
		bookItemToBeAdded.setItemType(BookingItemType.MOVED_IN);
		bookItemService.createBookitem(bookItemToBeAdded);
		return "redirect:/student/checkin/30";
	}

	private int getStudentId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountService.findByUsername(auth.getName());
		return account.getStudent().getId();
	}

}
