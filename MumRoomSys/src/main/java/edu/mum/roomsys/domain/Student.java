package edu.mum.roomsys.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
public class Student {
	@Id @GeneratedValue
	private int id;
	
	private String name;
	
	@Email
	private String email;
	
	@Pattern(regexp="\\d{3}-\\d{3}-\\d{4}")
	private String phone;

	@OneToOne(mappedBy="student", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private Account account;
	
	public Student() {
		super();
	}

	public Student(String name, String email, String phone) {
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
