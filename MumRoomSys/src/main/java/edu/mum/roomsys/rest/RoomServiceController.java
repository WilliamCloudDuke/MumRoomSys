package edu.mum.roomsys.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.service.RoomService;

@Controller
public class RoomServiceController {
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = { "/api/rooms" }, method = { RequestMethod.GET })
	@ResponseBody
	public List<Room> findAvailableRoom() {
		return roomService.findAvailableRoom();
	}
}
