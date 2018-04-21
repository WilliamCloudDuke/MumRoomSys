package edu.mum.roomsys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity 
public class Request {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(length=500, nullable = false)
	private String description;
	
	@Column(length = 100, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestType type;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	public Request() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
