package edu.mum.roomsys.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import edu.mum.roomsys.dao.BookingDao;
import edu.mum.roomsys.dao.CheckinDao;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;

@Service
@Transactional
public class CheckinService {

	@Autowired
	private CheckinDao checkinDao;

	@Autowired
	private BookingDao bookingDao;

	public Booking findBookinByStatusNew(int studentId) {
		PageRequest pr = new PageRequest(0, 1, new Sort(Direction.DESC, "moveInDate"));
		Page<Booking> pageBooking = checkinDao.findBookinByStatusNew(studentId, pr);
		if (pageBooking.hasContent()) {
			return pageBooking.getContent().get(0);
		}
		return null;
	}

	public Booking findById(int id) {
		return checkinDao.findById(id);
	}

	public List<Booking> findAllCheckin() {
		List<BookingStatus> status = Lists.newArrayList(BookingStatus.NEW, BookingStatus.CHECKED_OUT);
		return bookingDao.findByStatusIsNotInOrderByMoveInDateAsc(status);
	}

}
