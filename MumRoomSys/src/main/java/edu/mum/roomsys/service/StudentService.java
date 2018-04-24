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
import edu.mum.roomsys.domain.RoleType;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.rest.RestGenericException;
import edu.mum.roomsys.rest.RestGenericExceptionAdvice;
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
		if (student.getEmail() == null || studentDao.findByEmail(student.getEmail()) != null) {
			throw new RestGenericException("Invalid parameter: email");
		}
		
		Role role = student.getRole().equals(RoleType.DIRECTOR.toString())
				? roleDao.findByName(RoleType.DIRECTOR.toString())
				: roleDao.findByName(RoleType.STUDENT.toString());
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
		if (student.getAccount() != null) {
			student.setUsername(student.getAccount().getUsername());
			student.setRole(student.getAccount().getRole().getName());
			student.setEnabled(student.getAccount().isEnabled());
		}	
		if (student.getBookings().size() == 0) {
			student.setCanDelete(true);
		} else {
			student.setCanDelete(false);
		}
		return student;
	}

	@Transactional(value = TxType.REQUIRED)	
	public Student createStudentProfile(Student student) {
		return studentDao.save(student);
	}
	
	@Transactional(value = TxType.REQUIRED)	
	public Student updateStudentProfile(Student student) {
		Student current = studentDao.findOne(student.getId());
		if (current != null && student.getEmail().equals(current.getEmail())) {
			current.setName(student.getName());
			current.setPhone(student.getPhone());
			return studentDao.save(current);
		}
		throw new RestGenericException("Invalid parameters: Student id and email");
	}	
	
	@Transactional(value = TxType.REQUIRED)	
	public void deleteStudentProfile(Student student) {
		Student current = studentDao.findOne(student.getId());
		if (current != null && student.getBookings().size() == 0) {
			studentDao.delete(current);
			return;
		}
		throw new RestGenericException("Invalid parameters: Student not found or having booking data");
	}		
	
	@Transactional(value = TxType.REQUIRED)	
	public Student createStudentLogin(Student student) {
		if (student.getEmail() == null || studentDao.findByEmail(student.getEmail()) != null) {
			throw new RestGenericException("Invalid parameter: email");
		}		
		return studentDao.save(student);
	}	
	
	public Student findByEmail(String email) {
		return studentDao.findByEmail(email);
	}
}
