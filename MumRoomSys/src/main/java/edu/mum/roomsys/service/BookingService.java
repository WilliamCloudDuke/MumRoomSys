package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.BookingDao;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.util.PagingHelper;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	public Page<Booking> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "moveInDate"));
		return bookingDao.findAll(pReqest);
	}

	public PageDto getPage(Page<Booking> currentPage, int pageNo) {
		PagingHelper<Booking> paging = new PagingHelper<>(currentPage, pageNo);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(), paging.getTotalPage());
	}

}
