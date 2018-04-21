package edu.mum.roomsys.dto;

import javax.validation.constraints.NotNull;

public class RoomSearchCriteria {
	@NotNull(message="Input 0 or a positive number")
	private int roomNo;
	
	@NotNull(message="Input 0 or a positive number")
	private int buildingNo;
	
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
}
