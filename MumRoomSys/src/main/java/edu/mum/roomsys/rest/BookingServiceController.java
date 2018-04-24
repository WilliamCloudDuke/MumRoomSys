package edu.mum.roomsys.rest;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.dto.BookingDto;
import edu.mum.roomsys.service.BookingService;

@Controller
public class BookingServiceController {
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = { "/api/bookings" }, method = { RequestMethod.GET })
	@ResponseBody
	public Iterable<Booking> getBookings() {
		return bookingService.findAllBookings();
	}

	@RequestMapping(value = { "/api/bookings" }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BookingDto createBooking(@RequestBody BookingDto bookingDto) throws ParseException {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        booking.setStudent(bookingService.findStudentById(bookingDto.getStudentId()));
        booking.setRoom(bookingService.findRoomById(bookingDto.getRoomId()));
        
        Booking bookingCreated = bookingService.save(booking);
        
        return modelMapper.map(bookingCreated, BookingDto.class);
    }
	
	@RequestMapping(value = { "/api/bookings" }, method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBooking(@RequestBody BookingDto bookingDto) throws ParseException {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        bookingService.delete(booking.getId());
    }	
}
