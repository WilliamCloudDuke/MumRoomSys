package edu.mum.roomsys.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.roomsys.domain.Student;

public interface StudentDao extends PagingAndSortingRepository<Student, Integer> {

}
