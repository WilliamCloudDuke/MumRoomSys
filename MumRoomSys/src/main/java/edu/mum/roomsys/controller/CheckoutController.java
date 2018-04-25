package edu.mum.roomsys.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.roomsys.domain.BookItem;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.service.BookItemService;
import edu.mum.roomsys.service.BookingService;
import edu.mum.roomsys.service.CheckoutService;
import edu.mum.roomsys.service.RoomService;
import edu.mum.roomsys.service.SmsService;

@Controller
public class CheckoutController {

	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private BookItemService bookItemService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private SmsService smsService;

	@RequestMapping(path = { "/student/checkout/create/{id}" }, method = { RequestMethod.GET })
	public String getBookinByStatusCheckedin(@PathVariable("id") int id, Model model) {
		Booking booking = checkoutService.findById(id);
		model.addAttribute("booking", booking);
		BookItem bookItem = booking.getCheckoutRecord();
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckOutDate(new Date());
		bookItem.setRoomStatus(booking.getRoom().getStatus());
		bookItem.setComment(booking.getComment());
		bookItem.setStudentId(booking.getStudent().getId());
		model.addAttribute("booking", booking);
		model.addAttribute("bookingItem", bookItem);
		model.addAttribute("mainPage", "studentCheckout.jsp");
		return "index";
	}

	@SuppressWarnings("unused")
	@RequestMapping(path = { "/student/checkout/{id}" }, method = { RequestMethod.GET })
	public String getBookingForEdit(@PathVariable("id") int id, Model model) {
		model.addAttribute("mainPage", "studentCheckout.jsp");
		Booking booking = checkoutService.findById(id);
		model.addAttribute("booking", booking);
		BookItem bookItem = booking.getCheckoutRecord();
		bookItem.setWarningMessage("Check out for read only mode");
		bookItem.setDisabled(true);
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckOutDate(booking.getMoveOutDate());
		bookItem.setRoomStatus(booking.getRoom().getStatus());
		bookItem.setComment(booking.getComment());
		model.addAttribute("bookingItem", bookItem);
		return "index";
	}

	@SuppressWarnings("unused")
	@RequestMapping(path = { "/student/checkout/read/{id}" }, method = { RequestMethod.GET })
	public String getBookingForReadOnly(@PathVariable("id") int id, Model model) {
		model.addAttribute("mainPage", "studentCheckout.jsp");
		Booking booking = checkoutService.findById(id);
		model.addAttribute("booking", booking);
		BookItem bookItem = booking.getCheckoutRecord();
		bookItem.setSuccessMessage("Your Check out was successful");
		bookItem.setWarningMessage("Remember to return keys to Housing Department");
		bookItem.setDisabled(true);
		if (null == bookItem) {
			bookItem = new BookItem();
		}
		bookItem.setCheckOutDate(booking.getMoveOutDate());
		bookItem.setRoomStatus(booking.getRoom().getStatus());
		bookItem.setComment(booking.getComment());
		model.addAttribute("bookingItem", bookItem);
		return "index";
	}

	@RequestMapping(path = { "/student/checkout/add" }, method = { RequestMethod.POST })
	public String createCheckout(@Valid BookItem bookItemToBeAdded, Model model) {
		Booking bookingToBeUpdated = checkoutService.findBookinByStatusCheckedin(bookItemToBeAdded.getStudentId());
		bookingService.updateStatusMoveOutDateAndComment(bookingToBeUpdated, bookItemToBeAdded);
		bookItemService.createBookItemMovedOut(bookItemToBeAdded, bookingToBeUpdated);
		roomService.updateStatus(bookingToBeUpdated.getRoom(), bookItemToBeAdded.getRoomStatus());
		// SEND SMS MESSAGE TO STUDENT
//		smsService.sendSMS(bookingToBeUpdated.getStudent().getPhone(), "Mum Room System Notification - You "
//				+ bookItemToBeAdded.getBooking().getStudent().getName() + " have checked out of MUM ");
		return "redirect:/student/checkout/read/" + bookingToBeUpdated.getId();
	}

}
