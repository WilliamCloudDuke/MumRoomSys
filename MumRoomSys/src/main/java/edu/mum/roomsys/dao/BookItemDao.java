package edu.mum.roomsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.BookItem;

public interface BookItemDao extends PagingAndSortingRepository<BookItem, Integer> {

	@Query("select bi from BookItem bi join bi.booking b where b.student.id = :studentId and bi.booking.id= :bookingId and bi.itemType like 'MOVED_IN' ")
	public List<BookItem> findByBookingAndBookingItemTypeLikeNew(@Param("studentId") int studentId, @Param("bookingId") int bookingId);

}
