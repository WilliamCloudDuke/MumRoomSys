package edu.mum.roomsys.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.mum.roomsys.domain.Booking;

public interface BookingDao extends PagingAndSortingRepository<Booking, Integer> {

}
