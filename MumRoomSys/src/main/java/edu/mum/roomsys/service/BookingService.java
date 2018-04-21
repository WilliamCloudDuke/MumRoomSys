package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.BookingDao;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.dto.RoomSearchCriteria;
import edu.mum.roomsys.dto.SearchCriteria;
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
	
	public Page<Booking> search(SearchCriteria searchCriteria, int pageNo, int pageSize) {		
		if (searchCriteria.getCriteria() == null) {
			searchCriteria.setCriteria("");
			searchCriteria.setSearchBy("name");
		}		
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "moveInDate"));
		switch (searchCriteria.getSearchBy()) {
			case "name":
				return bookingDao.findByStudentNameLike(searchCriteria.getCriteria(), pReqest);
			case "email":
				return bookingDao.findByStudentEmailLike(searchCriteria.getCriteria(), pReqest);		
			default:
				return bookingDao.findByStudentNameLike(searchCriteria.getCriteria(), pReqest);
		}
	}
	
	public Page<Booking> searchByStatus(SearchCriteria searchCriteria, int pageNo, int pageSize) {		
		if (searchCriteria.getBookingStatus() == null) {
			searchCriteria.setBookingStatus("NEW");
		}				
		BookingStatus searchStatus = BookingStatus.valueOf(searchCriteria.getBookingStatus());
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "moveInDate"));
		return bookingDao.findByStatus(searchStatus, pReqest);
	}

	public Page<Booking> searchByBuilding(RoomSearchCriteria searchCriteria, int pageNo, int pageSize) {			
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "moveInDate"));
		if (searchCriteria.getBuildingNo() != 0 && searchCriteria.getRoomNo() != 0) {
			return bookingDao.findByRoomBuildNumberAndRoomNumber(searchCriteria.getBuildingNo(), 
					searchCriteria.getRoomNo(), pReqest);
		} else if (searchCriteria.getBuildingNo() != 0) {
			return bookingDao.findByRoomBuildNumber(searchCriteria.getBuildingNo(), pReqest);
		} else if (searchCriteria.getRoomNo() != 0) {
			return bookingDao.findByRoomNumber(searchCriteria.getRoomNo(), pReqest);
		} else {
			return bookingDao.findByRoomNumber(searchCriteria.getRoomNo(), pReqest);
		}
	}	
}
