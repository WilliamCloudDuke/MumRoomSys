package edu.mum.roomsys.dao;

import java.util.Collection;

import edu.mum.roomsys.domain.Request;



public abstract interface IRequestDao {
	
	public abstract void createRequest(Request request);
	public abstract void sendRequest(Request request);

	
	
}
