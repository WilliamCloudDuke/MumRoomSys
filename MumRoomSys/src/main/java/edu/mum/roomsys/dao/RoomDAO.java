package edu.mum.roomsys.dao;

import java.util.ArrayList;
import java.util.Collection;

import edu.mum.roomsys.domain.Room;

public class RoomDAO implements IRoomDAO {

	Collection<Room> roomList = new ArrayList<>();

	public void createRoom(Room room) {
		
	}

	public void updateRoom(Room room) {

	}

	public Room getRoom(int buildingNumber, int number) {
		return null;
	}

	public Collection<Room> getRooms(int buildingNumber) {
		return null;
	}

}
