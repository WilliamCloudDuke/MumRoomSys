package edu.mum.roomsys.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private int id;

	@Column(length = 4, nullable = false)
	private int buildNumber;

	@Column(length = 100, nullable = false)
	private RoomStatus roomStatus;

	@OneToMany(mappedBy = "room")
	private List<Room_Item> items;

	public Room() {
		super();
		items = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(int buildNumber) {
		this.buildNumber = buildNumber;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

}
