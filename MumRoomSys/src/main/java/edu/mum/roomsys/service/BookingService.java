package edu.mum.roomsys.service;

import java.util.Date;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.BookingDao;
import edu.mum.roomsys.dao.RoomDao;
import edu.mum.roomsys.dao.StudentDao;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;
import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.domain.RoomStatus;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.dto.RoomSearchCriteria;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.util.PagingHelper;

@Service
@Transactional
public class BookingService {

	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private StudentDao studentDao;

	public Page<Booking> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "moveInDate"));
		return bookingDao.findAll(pReqest);
	}

	public PageDto getPage(Page<Booking> currentPage, int pageNo) {
		PagingHelper<Booking> paging = new PagingHelper<>(currentPage, pageNo);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(),
				paging.getTotalPage());
	}

	public PageDto getPageStudent(Page<Student> currentPage, int pageNo) {
		PagingHelper<Student> paging = new PagingHelper<>(currentPage, pageNo);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(),
				paging.getTotalPage());
	}

	public PageDto getPageRoom(Page<Room> currentPage, int pageNo) {
		PagingHelper<Room> paging = new PagingHelper<>(currentPage, pageNo);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(),
				paging.getTotalPage());
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

	public Page<Room> searchByRoomNumber(RoomSearchCriteria searchCriteria, int pageNo, int pageSize) {
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "buildNumber", "number"));
		if (searchCriteria.getBuildingNo() != 0 && searchCriteria.getRoomNo() != 0) {
			return roomDao.findByBuildNumberAndNumber(searchCriteria.getBuildingNo(), searchCriteria.getRoomNo(),
					pReqest);
		} else if (searchCriteria.getBuildingNo() != 0) {
			return roomDao.findByBuildNumber(searchCriteria.getBuildingNo(), pReqest);
		} else if (searchCriteria.getRoomNo() != 0) {
			return roomDao.findByNumber(searchCriteria.getRoomNo(), pReqest);
		} else {
			return roomDao.findByNumber(searchCriteria.getRoomNo(), pReqest);
		}
	}

	public Page<Room> searchByRoomStatus(RoomSearchCriteria searchCriteria, int pageNo, int pageSize) {
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "buildNumber", "number"));
		if (searchCriteria.getRoomStatus() == null) {
			searchCriteria.setRoomStatus("READY");
		}
		RoomStatus status = RoomStatus.valueOf(searchCriteria.getRoomStatus());
		return roomDao.findByStatus(status, pReqest);
	}

	public Page<Student> searchByStudent(SearchCriteria searchCriteria, int pageNo, int pageSize) {
		if (searchCriteria.getCriteria() == null) {
			searchCriteria.setCriteria("");
			searchCriteria.setSearchBy("name");
		}
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "name"));
		switch (searchCriteria.getSearchBy()) {
		case "name":
			return studentDao.findAvailableStudentByNameLike(searchCriteria.getCriteria(), pReqest);
		case "email":
			return studentDao.findAvailableStudentByEmailLike(searchCriteria.getCriteria(), pReqest);
		default:
			return studentDao.findAvailableStudentByNameLike(searchCriteria.getCriteria(), pReqest);
		}
	}

	public Student findStudentById(int id) {
		return studentDao.findOne(id);
	}

	public Room findRoomById(int id) {
		return roomDao.findOne(id);
	}

	public Booking createBooking(Student student, Room room) {
		Booking booking = new Booking();
		booking.setStatus(BookingStatus.NEW);
		booking.setStudent(student);
		booking.setRoom(room);
		return booking;
	}

	@Transactional(value = TxType.REQUIRED)
	public void save(Booking booking) {
		Room room = roomDao.findOne(booking.getRoom().getId());
		room.setStatus(RoomStatus.RESERVED);
		roomDao.save(room);
		bookingDao.save(booking);
	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(int id) throws Exception {
		Booking b = bookingDao.findOne(id);
		if (b != null && b.getStatus() != BookingStatus.NEW) {
			throw new Exception("Cannot delete booking");
		}

		bookingDao.delete(b);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateStatusCkeckInAndMoveInDate(Booking booking, Date checkInDate) {
		booking.setStatus(BookingStatus.CHECKED_IN);
		bookingDao.updateStatusAndMoveInDate(booking.getStatus(), checkInDate, booking.getId());
	}

}
