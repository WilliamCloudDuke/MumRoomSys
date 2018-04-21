package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.CheckinDao;
import edu.mum.roomsys.domain.Booking;

@Service
public class CheckinService {

	@Autowired
	private CheckinDao checkinDao;

	public Booking findByStatusNewLike(int studentId) {
		return checkinDao.findByStatusNewLike(studentId);
	}

}
