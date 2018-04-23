package edu.mum.roomsys.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class StudentDto {
	private int id;

	@NotNull
	private String name;

	@Email
	@NotNull
	private String email;

	private String phone;
	
	public StudentDto() {
		super();
	}

	public StudentDto(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
