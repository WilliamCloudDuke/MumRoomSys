package edu.mum.roomsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.BookItemDao;
import edu.mum.roomsys.domain.BookItem;

@Service
public class BookItemService {

	@Autowired
	private BookItemDao bookItemDao;

	public List<BookItem> findByBookingAndBookingItemTypeLikeNew(int studentId, int bookingId) {
		return bookItemDao.findByBookingAndBookingItemTypeLikeNew(studentId, bookingId);
	}
}
