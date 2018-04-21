package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.RoomDao;
import edu.mum.roomsys.domain.Room;

@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	public Page<Room> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "number"));
		return roomDao.findAll(pReqest);
	}

}
