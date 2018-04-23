package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.AccountDao;
import edu.mum.roomsys.dao.RequestDao;
import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.domain.Booking;
import edu.mum.roomsys.domain.BookingStatus;
import edu.mum.roomsys.domain.Request;
import edu.mum.roomsys.domain.RequestType;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.dto.RequestSearchCriteria;
import edu.mum.roomsys.dto.RoomSearchCriteria;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.util.PagingHelper;


@Service
public class RequestService {
	@Autowired
	private RequestDao requestDao;
	
	private Request newRequest;

	@Autowired
	private AccountDao accountDao;

	public Account findByUsername(String userName) {
		return accountDao.findByUsername(userName);
	}

	
	
	public Request createRequest(RequestType req,String disc,Student std) {
		newRequest=new Request();
		newRequest.setDescription(disc);
		newRequest.setType(req);
		newRequest.setStudent(std);
		//newRequest.getStudent().setId(id);
				
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		
		
		
		
		return requestDao.save(newRequest);
	}
	
	public Page<Request> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "type"));
		return requestDao.findAll(pReqest);
	}
	
	public Page<Request> findByStudent(int studentId, int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "type"));
		return requestDao.findByStudentId(studentId, pReqest);
	}

	public PageDto getPage(Page<Request> page, int current) {
		PagingHelper<Request> paging = new PagingHelper<>(page, current);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(), paging.getTotalPage());
	}

	public Page<Request> searchByType(RequestType requestType, int pageNo, int pageSize) {
					
		RequestType searchStatus = requestType;
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "type"));
		return requestDao.findByType(searchStatus, pReqest);
	}
	
	
	public Page<Request> findByStudentId(RequestSearchCriteria searchCriteria, int pageNo, int pageSize) {			
		int searchStatus = searchCriteria.getStudentId();
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "type"));
		return requestDao.findByStudentId(searchStatus, pReqest);
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
