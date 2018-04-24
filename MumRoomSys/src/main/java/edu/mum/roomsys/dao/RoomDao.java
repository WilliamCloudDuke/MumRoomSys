package edu.mum.roomsys.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.domain.RoomStatus;

public interface RoomDao extends PagingAndSortingRepository<Room, Integer> {
	public List<Room> findByStatus(RoomStatus status);
	
	public List<Room> findByStatusIsNotIn(List<RoomStatus> status);
	
	public Page<Room> findByStatus(RoomStatus status, Pageable pageable);

	public Page<Room> findByBuildNumberAndNumber(int buildNumber, int number, Pageable pageable);

	public Page<Room> findByBuildNumber(int buildNumber, Pageable pageable);

	public Page<Room> findByNumber(int number, Pageable pageable);
	
	public Room findByBuildNumberAndNumberAndStatus(int buildNumber, int number, RoomStatus roomStatus);

	@Modifying
	@Query("update Room r set r.status = :status where r.id = :id")
	public int updateStatus(@Param("status") RoomStatus status, @Param("id") int id);

}