package edu.mum.roomsys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.domain.RoomStatus;

public interface RoomDao extends PagingAndSortingRepository<Room, Integer> {
	public Page<Room> findByStatus(RoomStatus status, Pageable pageable);
	public Page<Room> findByBuildNumberAndNumber(int buildNumber, int number, Pageable pageable);
	public Page<Room> findByBuildNumber(int buildNumber, Pageable pageable);
	public Page<Room> findByNumber(int number, Pageable pageable);
}