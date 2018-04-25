package edu.mum.roomsys.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;

public interface BookingDao extends PagingAndSortingRepository<Booking, Integer> {

	@Query("select distinct b from Booking b join b.student s join b.room r left join b.bookItems i where s.name like %:name%")
	public Page<Booking> findByStudentNameLike(@Param("name") String name, Pageable pageable);

	@Query("select distinct b from Booking b join b.student s join b.room r left join b.bookItems i where s.email like :email%")
	public Page<Booking> findByStudentEmailLike(@Param("email") String email, Pageable pageable);

	public Page<Booking> findByStatus(BookingStatus status, Pageable pageable);

	public Page<Booking> findByRoomBuildNumber(int buildNumber, Pageable pageable);

	public Page<Booking> findByRoomNumber(int number, Pageable pageable);

	public Page<Booking> findByRoomBuildNumberAndRoomNumber(int buildNumber, int number, Pageable pageable);

	@Modifying
	@Query("update Booking b set b.status = :status, b.moveInDate = :moveInDate where b.id = :id")
	public int updateStatusAndMoveInDate(@Param("status") BookingStatus status, @Param("moveInDate") Date moveInDate,
			@Param("id") int id);

	@Modifying
	@Query("update Booking b set b.status = :status, b.moveOutDate = :moveOutDate, b.comment = :comment where b.id = :id")
	public int updateStatusMoveOutDateAndComment(@Param("status") BookingStatus status,
			@Param("moveOutDate") Date moveOutDate, @Param("comment") String comment, @Param("id") int id);

	public List<Booking> findByStatusIsNotInOrderByMoveInDateAsc(Collection<BookingStatus> status);

	public List<Booking> findByStatusIsNotInOrderByMoveOutDateAsc(Collection<BookingStatus> status);

}
