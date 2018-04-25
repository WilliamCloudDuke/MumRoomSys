package edu.mum.roomsys.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.service.CheckoutService;

@RestController
public class CheckoutServiceController {

	@Autowired
	private CheckoutService checkoutService;

	@RequestMapping(value = { "/api/bookingsCheckedout" }, method = { RequestMethod.GET })
	public List<Booking> getBookingsCheckedout() {
		return checkoutService.findAllCheckout();
	}

}
