package edu.mum.roomsys.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.RoomDao;
import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.domain.RoomStatus;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	public Page<Room> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "number"));
		return roomDao.findAll(pReqest);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateStatusOccupied(Room room) {
		room.setStatus(RoomStatus.OCCUPIED);
		roomDao.updateStatus(room.getStatus(), room.getId());
	}

}
