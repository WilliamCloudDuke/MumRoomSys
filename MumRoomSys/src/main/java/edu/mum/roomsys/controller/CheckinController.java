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
import edu.mum.roomsys.service.AccountService;
import edu.mum.roomsys.service.BookItemService;
import edu.mum.roomsys.service.BookingService;
import edu.mum.roomsys.service.CheckinService;
import edu.mum.roomsys.service.RoomService;
import edu.mum.roomsys.service.SmsService;

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
	@Autowired
	private RoomService roomService;
	@Autowired
	private SmsService smsService;

	@GetMapping({ "/student/checkin" })
	public String getBookingByStatusNew(Model model) {
		model.addAttribute("mainPage", "studentCheckin.jsp");
		Booking booking = checkinService.findBookinByStatusNew(getStudentId());
		if (null == booking) {
			Booking bookingEmpty = new Booking();
			BookItem bookItem = new BookItem();
			bookItem.setErrorMessage("You cannot do a Checkin operation again, contact your Resident Advisor/Director");
			bookItem.setDisabled(true);
			model.addAttribute("booking", bookingEmpty);
			model.addAttribute("bookingItem", bookItem);
			return "student_index";
		}
		BookItem bookItem = booking.getCheckinRecord();
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckInDate(new Date());
		model.addAttribute("booking", booking);
		model.addAttribute("bookingItem", bookItem);
		return "student_index";
	}

	@SuppressWarnings("unused")
	@RequestMapping(path = { "/student/checkin/{id}" }, method = { RequestMethod.GET })
	public String getBookingForEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("mainPage", "studentCheckin.jsp");
		Booking booking = checkinService.findById(id);
		model.addAttribute("booking", booking);
		BookItem bookItem = booking.getCheckinRecord();
		bookItem.setWarningMessage("Check in for read only mode");
		bookItem.setDisabled(true);
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckInDate(booking.getMoveInDate());
		model.addAttribute("bookingItem", bookItem);
		return "index";
	}

	@SuppressWarnings("unused")
	@RequestMapping(path = { "/student/checkin/read/{id}" }, method = { RequestMethod.GET })
	public String getBookingForReadOnly(@PathVariable("id") int id, Model model) {
		model.addAttribute("mainPage", "studentCheckin.jsp");
		Booking booking = checkinService.findById(id);
		model.addAttribute("booking", booking);
		BookItem bookItem = booking.getCheckinRecord();
		bookItem.setSuccessMessage("Your Check in was successful");
		bookItem.setDisabled(true);
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckInDate(booking.getMoveInDate());
		model.addAttribute("bookingItem", bookItem);
		return "student_index";
	}

	@RequestMapping(path = { "/student/checkin/add" }, method = { RequestMethod.POST })
	public String createCheckin(@Valid BookItem bookItemToBeAdded, Model model) {
		Booking bookingToBeUpdated = checkinService.findBookinByStatusNew(getStudentId());
		bookingService.updateStatusCkeckinAndMoveInDate(bookingToBeUpdated, bookItemToBeAdded.getCheckInDate());
		bookItemService.createBookItemMovedIn(bookItemToBeAdded, bookingToBeUpdated);
		roomService.updateStatusOccupied(bookingToBeUpdated.getRoom());
		Account adminAccount = accountService.findAdminByBuildingNumber(bookingToBeUpdated.getRoom().getBuildNumber());
		//SEND SMS MESSAGE TO BUILDING ADMIN 
		//smsService.sendSMS(adminAccount.getStudent().getPhone(), "Mum Room System Notification - The student "
		//		+ bookItemToBeAdded.getBooking().getStudent().getName() + " has done a check in");
		return "redirect:/student/checkin/read/" + bookingToBeUpdated.getId();
	}

	private int getStudentId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountService.findByUsername(auth.getName());
		return account.getStudent().getId();
	}

}
