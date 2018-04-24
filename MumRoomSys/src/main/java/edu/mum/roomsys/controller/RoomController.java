package edu.mum.roomsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.roomsys.service.RoomService;

@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping({"/rooms/available"})
	public String getAvailableRooms(Model model) {
		model.addAttribute("rooms", roomService.findAvailableRoom());
		model.addAttribute("mainPage", "availableRoom.jsp");
		return "index";
	}
}
