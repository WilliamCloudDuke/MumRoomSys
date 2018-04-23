package edu.mum.roomsys.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.AccountDao;
import edu.mum.roomsys.dao.RoleDao;
import edu.mum.roomsys.dao.StudentDao;
import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.domain.Role;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.util.PagingHelper;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Iterable<Student> findAll() {
		return studentDao.findAll();
	}

	public Page<Student> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "name"));
		return studentDao.findAll(pReqest);
	}

	public PageDto getPage(Page<Student> page, int current) {
		PagingHelper<Student> paging = new PagingHelper<>(page, current);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(),
				paging.getTotalPage());
	}

	public Page<Student> search(SearchCriteria searchCriteria, int pageNo, int pageSize) {
		if (searchCriteria.getCriteria() == null) {
			searchCriteria.setCriteria("");
			searchCriteria.setSearchBy("name");
		}
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "name"));
		switch (searchCriteria.getSearchBy()) {
		case "name":
			return studentDao.findByNameLike(searchCriteria.getCriteria(), pReqest);
		case "email":
			return studentDao.findByEmailLike(searchCriteria.getCriteria(), pReqest);
		default:
			return studentDao.findByNameLike(searchCriteria.getCriteria(), pReqest);
		}
	}

	@Transactional(value = TxType.REQUIRED)
	public void createStudent(Student student) {
		Role role = student.getRole().toUpperCase() == "DIRECTOR" ? roleDao.findByName("DIRECTOR")
				: roleDao.findByName("STUDENT");
		Account account = new Account(student.getUsername(), student.getPassword(), student.getEmail(),
				student.isEnabled(), role);
		student.setAccount(account);
		accountDao.save(account);
		studentDao.save(student);
	}

	@Transactional(value = TxType.REQUIRED)
	public void editStudent(Student student) {
		studentDao.save(student);
	}

	@Transactional(value = TxType.REQUIRED)
	public void resetPassword(Student student) {
		Student currentStudent = studentDao.findOne(student.getId());
		Account currentAccount = currentStudent.getAccount();
		if (currentAccount != null) {
			currentAccount.setPassword(passwordEncoder.encode(student.getPassword()));
			accountDao.save(currentAccount);
		}
	}

	@Transactional(value = TxType.REQUIRED)
	public void enable(Student student) {
		Student currentStudent = studentDao.findOne(student.getId());
		Account currentAccount = currentStudent.getAccount();
		if (currentAccount != null) {
			currentAccount.setEnabled(student.isEnabled());
			accountDao.save(currentAccount);
		}
	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(Student student) {
		Student current = studentDao.findOne(student.getId());
		if (current != null && current.getBookings().size() == 0) {
			studentDao.delete(current);
		}
	}

	public Student findById(int id) {
		Student student = studentDao.findOne(id);
		student.setUsername(student.getAccount().getUsername());
		student.setRole(student.getAccount().getRole().getName());
		student.setEnabled(student.getAccount().isEnabled());
		if (student.getBookings().size() == 0) {
			student.setCanDelete(true);
		} else {
			student.setCanDelete(false);
		}
		return student;
	}
}
