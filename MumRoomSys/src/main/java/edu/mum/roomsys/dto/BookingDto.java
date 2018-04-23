package edu.mum.roomsys.dto;

import java.io.Serializable;

public class BookingDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int studentId;
	private int roomId;
	private String studentName;
	private String studentEmail;
	private String buildingNumner;
	private String roomNumber;
	
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getBuildingNumner() {
		return buildingNumner;
	}
	public void setBuildingNumner(String buildingNumner) {
		this.buildingNumner = buildingNumner;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

}
