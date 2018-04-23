package edu.mum.roomsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.roomsys.domain.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {
	public Account findByUsername(String username);
	public Account findByEmail(String email);
}
