package edu.mum.roomsys.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private int id;

	@Column(length = 4, nullable = false)
	private int buildNumber;

	@Column(length = 4, nullable = false)
	private int number;

	@Enumerated(EnumType.STRING)
	@Column(length = 100, nullable = false)
	private RoomStatus status;

	@OneToOne(mappedBy = "room")
	private Room_Item item;

	@OneToMany(mappedBy = "room")
	private List<Booking> bookings;

	
	public Room() {
		super();
		bookings = new ArrayList<>();
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

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public Room_Item getItem() {
		return item;
	}

	public void setItem(Room_Item item) {
		this.item = item;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	
}
