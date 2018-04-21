package edu.mum.roomsys.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RoomItem {

	@Id
	@GeneratedValue
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus walls;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus windows;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus screens;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus blinds;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus sink;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus counter;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus mirror;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus floor;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus closet;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus towel;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private ItemStatus thermostat;

	@JoinColumn(name = "room_id", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Room room;

	public RoomItem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemStatus getWalls() {
		return walls;
	}

	public void setWalls(ItemStatus walls) {
		this.walls = walls;
	}

	public ItemStatus getWindows() {
		return windows;
	}

	public void setWindows(ItemStatus windows) {
		this.windows = windows;
	}

	public ItemStatus getScreens() {
		return screens;
	}

	public void setScreens(ItemStatus screens) {
		this.screens = screens;
	}

	public ItemStatus getBlinds() {
		return blinds;
	}

	public void setBlinds(ItemStatus blinds) {
		this.blinds = blinds;
	}

	public ItemStatus getSink() {
		return sink;
	}

	public void setSink(ItemStatus sink) {
		this.sink = sink;
	}

	public ItemStatus getCounter() {
		return counter;
	}

	public void setCounter(ItemStatus counter) {
		this.counter = counter;
	}

	public ItemStatus getMirror() {
		return mirror;
	}

	public void setMirror(ItemStatus mirror) {
		this.mirror = mirror;
	}

	public ItemStatus getFloor() {
		return floor;
	}

	public void setFloor(ItemStatus floor) {
		this.floor = floor;
	}

	public ItemStatus getCloset() {
		return closet;
	}

	public void setCloset(ItemStatus closet) {
		this.closet = closet;
	}

	public ItemStatus getTowel() {
		return towel;
	}

	public void setTowel(ItemStatus towel) {
		this.towel = towel;
	}

	public ItemStatus getThermostat() {
		return thermostat;
	}

	public void setThermostat(ItemStatus thermostat) {
		this.thermostat = thermostat;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
