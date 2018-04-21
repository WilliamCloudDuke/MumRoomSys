package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.RequestDao;
import edu.mum.roomsys.domain.Request;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.util.PagingHelper;

@Service
public class RequestService {
	@Autowired
	private RequestDao requestDao;
	
	public Page<Request> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "id"));
		return requestDao.findAll(pReqest);
	}
	
	public Page<Request> findByStudent(int studentId, int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "id"));
		return requestDao.findByStudentId(studentId, pReqest);
	}

	public PageDto getPage(Page<Request> page, int current) {
		PagingHelper<Request> paging = new PagingHelper<>(page, current);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(), paging.getTotalPage());
	}

}
