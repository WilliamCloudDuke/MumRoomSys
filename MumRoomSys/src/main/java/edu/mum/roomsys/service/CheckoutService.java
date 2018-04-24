package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.CheckoutDao;
import edu.mum.roomsys.domain.Booking;

@Service
public class CheckoutService {

	@Autowired
	private CheckoutDao checkoutDao;

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

}
