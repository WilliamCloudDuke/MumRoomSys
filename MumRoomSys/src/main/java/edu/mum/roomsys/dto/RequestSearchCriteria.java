package edu.mum.roomsys.dto;

import javax.validation.constraints.NotNull;

import edu.mum.roomsys.domain.Request;
import edu.mum.roomsys.domain.RequestType;

public class RequestSearchCriteria {
	@NotNull
	private int studentId;
	
	@NotNull
	private RequestType type;
	
	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	
	
	

}
