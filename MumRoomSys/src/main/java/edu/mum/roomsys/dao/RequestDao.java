package edu.mum.roomsys.dao;

import org.springframework.data.domain.Page;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.roomsys.domain.Request;
import edu.mum.roomsys.domain.RequestType;
import edu.mum.roomsys.domain.Room;
import edu.mum.roomsys.domain.RoomStatus;
import edu.mum.roomsys.domain.Student;


@Repository
public interface RequestDao extends PagingAndSortingRepository<Request, Integer> {
	
	
	//retrive request based on the given student 
	public Page<Request> findByStudent(Student student, Pageable pageable);

	
	
	/*@Query("select req from Request req join req.student std  where req.type like %:type%")
	public Page<Request> findByType(@Param("type") RequestType searchStatus, Pageable pageable);*/
   
	public Request save(Request request);

	
	

	
}
