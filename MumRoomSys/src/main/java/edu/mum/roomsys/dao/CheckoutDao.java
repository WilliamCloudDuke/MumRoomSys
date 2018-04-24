package edu.mum.roomsys.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Booking;

public interface CheckoutDao extends PagingAndSortingRepository<Booking, Integer> {

	@Query("select b from Booking b join b.student s where s.id = :studentId and b.status like 'CHECKED_IN' ")
	public Booking findBookinByStatusCheckedin(@Param("studentId") int studentId);

	public Booking findById(@Param("id") int id);

}
