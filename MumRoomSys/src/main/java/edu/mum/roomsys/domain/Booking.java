package edu.mum.roomsys.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Booking {

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.DATE)
	private Date moveInDate;

	@Temporal(TemporalType.DATE)
	private Date moveOutDate;

	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	@JoinColumn(name = "room_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Room room;

	@OneToMany(mappedBy = "booking")
	private List<BookItem> bookItems;

	@JoinColumn(name = "student_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;

	public Booking() {
		super();
		bookItems = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<BookItem> getBookItems() {
		return bookItems;
	}

	public void setBookItems(List<BookItem> bookItems) {
		this.bookItems = bookItems;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
