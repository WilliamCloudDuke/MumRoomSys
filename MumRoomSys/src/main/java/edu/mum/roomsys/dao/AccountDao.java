package edu.mum.roomsys.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Account;

public interface AccountDao extends PagingAndSortingRepository<Account, Integer> {

	public Account findByUsername(@Param("userName") String userName);

}
