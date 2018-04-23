package edu.mum.roomsys.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Booking;

public abstract interface CheckinDao extends PagingAndSortingRepository<Booking, Integer> {

	@Query("select b from Booking b join b.student s where s.id = :studentId and b.status like 'NEW' ")
	public Booking findByStatusNewLike(@Param("studentId") int studentId);

	public Booking save(Booking booking);

}
