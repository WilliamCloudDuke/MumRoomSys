package edu.mum.roomsys.dao;

import java.util.Collection;

import edu.mum.roomsys.domain.Room;

public abstract interface IRoomDAO {

	public abstract void createRoom(Room room);

	public abstract void updateRoom(Room room);

	public abstract Room getRoom(int buildingNumber, int number);

	public Collection<Room> getRooms(int buildingNumber);

}
