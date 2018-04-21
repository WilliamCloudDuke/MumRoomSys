package edu.mum.roomsys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.roomsys.domain.Student;

public interface StudentDao extends PagingAndSortingRepository<Student, Integer> {
	public Page<Student> findByName(String name, Pageable pageable);
}
