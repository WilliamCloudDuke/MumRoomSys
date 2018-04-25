package edu.mum.roomsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import edu.mum.roomsys.dao.BookingDao;
import edu.mum.roomsys.dao.CheckoutDao;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;

@Service
public class CheckoutService {

	@Autowired
	private CheckoutDao checkoutDao;

	@Autowired
	private BookingDao bookingDao;

	public Booking findBookinByStatusCheckedin(int studentId) {
		Booking booking = checkoutDao.findBookinByStatusCheckedin(studentId);
		if (null == booking) {
			return null;
		}
		return booking;
	}

	public Booking findById(int id) {
		return checkoutDao.findById(id);
	}

	public List<Booking> findAllCheckout() {
		List<BookingStatus> status = Lists.newArrayList(BookingStatus.NEW, BookingStatus.CHECKED_IN);
		return bookingDao.findByStatusIsNotInOrderByMoveOutDateAsc(status);
	}

}
