package edu.mum.roomsys.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.service.CheckinService;

@RestController
public class CheckinServiceController {

	@Autowired
	private CheckinService checkinService;

	@RequestMapping(value = { "/api/bookingsCheckedin" }, method = { RequestMethod.GET })
	public List<Booking> getBookingsCheckedin() {
		return checkinService.findAllCheckin();
	}

}
