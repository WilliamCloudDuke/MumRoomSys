package edu.mum.roomsys.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.roomsys.domain.Room;

public abstract interface RoomDao extends PagingAndSortingRepository<Room, Integer> {

}
