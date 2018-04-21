package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.AccountDao;
import edu.mum.roomsys.dao.StudentDao;
import edu.mum.roomsys.domain.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private AccountDao accountDao;
	
	public Page<Student> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "name"));
		return studentDao.findAll(pReqest);
	}
	
}
