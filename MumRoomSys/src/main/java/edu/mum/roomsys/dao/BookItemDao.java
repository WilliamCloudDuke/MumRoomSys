package edu.mum.roomsys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.BookItem;

public interface BookItemDao extends PagingAndSortingRepository<BookItem, Integer> {

	@Query("select bi from BookItem bi join bi.booking b where b.student.id = :studentId and bi.booking.id= :bookingId and bi.itemType like 'MOVED_IN' ORDER BY b.moveInDate DESC")
	public Page<BookItem> findByBookingAndBookingItemTypeLikeNew(@Param("studentId") int studentId,
			@Param("bookingId") int bookingId, Pageable pageable);

}
