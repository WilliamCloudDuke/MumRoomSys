package edu.mum.roomsys.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.domain.Student;

public interface AccountDao extends PagingAndSortingRepository<Student, Integer> {

	public Account findByName(@Param("name") String name);

}
