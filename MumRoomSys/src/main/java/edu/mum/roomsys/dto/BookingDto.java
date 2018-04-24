package edu.mum.roomsys.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BookingDto {
	private int id;
	
	@NotNull
	private int studentId;
	
	@NotNull
	private int roomId;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date moveInDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date moveOutDate;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Date getMoveInDate() {
		return moveInDate;
	}
	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}
	public Date getMoveOutDate() {
		return moveOutDate;
	}
	public void setMoveOutDate(Date moveOutDate) {
		this.moveOutDate = moveOutDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
