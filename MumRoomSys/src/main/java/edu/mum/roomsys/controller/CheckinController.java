package edu.mum.roomsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.domain.BookItem;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.service.AccountService;
import edu.mum.roomsys.service.BookItemService;
import edu.mum.roomsys.service.CheckinService;

@Controller
public class CheckinController {

	@Autowired
	private CheckinService checkinService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private BookItemService bookItemService;

	@GetMapping({ "/student/checkin" })
	public String getBookingNew(Model model) {
		model.addAttribute("mainPage", "studentCheckin.jsp");
		Booking booking = checkinService.findByStatusNewLike(getStudentId());
		model.addAttribute("bookingNew", booking);
		List<BookItem> booksItems = bookItemService.findByBookingAndBookingItemTypeLikeNew(getStudentId(),
				booking.getId());
		if (!booksItems.isEmpty()) {
			System.out.println("Has Data");
		} else {
			System.out.println("It is empty");
		}
		model.addAttribute("bookingItemsNew",
				bookItemService.findByBookingAndBookingItemTypeLikeNew(getStudentId(), booking.getId()));
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "student_index";
	}

	private int getStudentId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountService.findByUsername(auth.getName());
		return account.getStudent().getId();
	}

}
