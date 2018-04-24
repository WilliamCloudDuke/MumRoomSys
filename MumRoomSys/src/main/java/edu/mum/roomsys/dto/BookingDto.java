package edu.mum.roomsys.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BookingDto {
	private int id;
	
	@NotNull
	private String studentEmail;
	
	@NotNull
	private int buildingNumber;
	
	@NotNull
	private int roomNumber;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date moveInDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date moveOutDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
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

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
}
