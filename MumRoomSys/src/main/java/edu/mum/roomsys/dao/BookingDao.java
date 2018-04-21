package edu.mum.roomsys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;

public interface BookingDao extends PagingAndSortingRepository<Booking, Integer> {

	@Query("select b from Booking b join b.student s join b.room r left join b.bookItems i where s.name like %:name%")
	public Page<Booking> findByStudentNameLike(@Param("name") String name, Pageable pageable);

	@Query("select b from Booking b join b.student s join b.room r left join b.bookItems i where s.email like :email%")
	public Page<Booking> findByStudentEmailLike(@Param("email") String email, Pageable pageable);
	
	public Page<Booking> findByStatus(BookingStatus status, Pageable pageable);
}
