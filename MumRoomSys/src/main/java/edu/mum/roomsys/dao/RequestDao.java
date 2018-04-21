package edu.mum.roomsys.dao;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Request;


public interface RequestDao extends PagingAndSortingRepository<Request, Integer> {

	//@Query("select req from Request req join req.student std  where std.id = :id")
	public Page<Request> findByStudentId(@Param("id") int id, Pageable pageable);

	
}
