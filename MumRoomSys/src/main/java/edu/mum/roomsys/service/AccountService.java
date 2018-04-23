package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.AccountDao;
import edu.mum.roomsys.domain.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	public Account findByUsername(String name) {
		return accountDao.findByUsername(name);
	}
}
