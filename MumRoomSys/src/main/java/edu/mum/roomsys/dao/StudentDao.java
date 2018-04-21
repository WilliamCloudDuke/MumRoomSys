package edu.mum.roomsys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Student;

public interface StudentDao extends PagingAndSortingRepository<Student, Integer> {
	@Query("select s from Student s join s.account a join a.role r where s.name like %:name%")
	public Page<Student> findByNameLike(@Param("name") String name, Pageable pageable);
	
	@Query("select s from Student s join s.account a join a.role r where s.email like :email%")
	public Page<Student> findByEmailLike(@Param("email") String email, Pageable pageable);
}
