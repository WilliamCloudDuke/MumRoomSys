package edu.mum.roomsys.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book_item")
public class BookItem {

	@Id
	@GeneratedValue
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private BookingItemType itemType;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus walls;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus windows;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus screens;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus blinds;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus sink;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus counter;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus mirror;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus floor;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus closet;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus towel;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus shower;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ItemStatus thermostat;

	@Transient
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkInDate;

	@Transient
	private String comment;

	@Transient
	@Enumerated(EnumType.STRING)
	private RoomStatus roomStatus;

	@Transient
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkOutDate;

	@Transient
	private String successMessage;

	@Transient
	private String errorMessage;

	@Transient
	private String warningMessage;

	@Transient
	private boolean disabled;

	@Transient
	private int studentId;

	@JsonIgnore
	@JoinColumn(name = "booking_id", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Booking booking;

	public BookItem() {
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public BookingItemType getItemType() {
		return itemType;
	}

	public void setItemType(BookingItemType itemType) {
		this.itemType = itemType;
	}

	public ItemStatus getShower() {
		return shower;
	}

	public void setShower(ItemStatus shower) {
		this.shower = shower;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getWarningMessage() {
		return warningMessage;
	}

	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public RoomStatus getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}
