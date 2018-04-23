package edu.mum.roomsys.dto;

import javax.validation.constraints.NotNull;

public class RoomSearchCriteria {
	@NotNull
	private int roomNo;
	
	@NotNull
	private int buildingNo;
	
	private String roomStatus;
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
}
