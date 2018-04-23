package edu.mum.roomsys.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.BookItemDao;
import edu.mum.roomsys.domain.BookItem;
import edu.mum.roomsys.domain.BookingItemType;

@Service
public class BookItemService {

	@Autowired
	private BookItemDao bookItemDao;

	public BookItem findByBookingAndBookingItemTypeLikeNew(int studentId, int bookingId) {
		PageRequest pr = new PageRequest(0, 1);
		Page<BookItem> pageBookItem = bookItemDao.findByBookingAndBookingItemTypeLikeNew(studentId, bookingId, pr);
		if (pageBookItem.hasContent()) {
			return pageBookItem.getContent().get(0);
		}
		return null;
	}

	@Transactional(value = TxType.REQUIRED)
	public void createBookitem(BookItem bookItem) {
		bookItem.setItemType(BookingItemType.MOVED_IN);
		bookItemDao.save(bookItem);
	}

	public BookItem findById(int id) {
		return bookItemDao.findOne(id);
	}
}
