package edu.mum.roomsys.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date moveInDate;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date moveOutDate;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;

	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	@Column(length = 255)
	private String comment;

	@JoinColumn(name = "room_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Room room;

	@OneToMany(mappedBy = "booking", cascade = { CascadeType.REMOVE })
	private List<BookItem> bookItems = new ArrayList<>();

	@JoinColumn(name = "student_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Student student;

	public Booking() {
		super();
		bookItems = new ArrayList<>();
	}

	public BookItem getCheckinRecord() {
		Optional<BookItem> item = bookItems.stream().filter(i -> i.getItemType() == BookingItemType.MOVED_IN)
				.findFirst();
		if (item.isPresent()) {
			return item.get();
		}
		return null;
	}

	public BookItem getCheckoutRecord() {
		Optional<BookItem> item = bookItems.stream().filter(i -> i.getItemType() == BookingItemType.MOVED_OUT)
				.findFirst();
		if (item.isPresent()) {
			return item.get();
		}
		return null;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
