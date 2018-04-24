package edu.mum.roomsys.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.AccountDao;
import edu.mum.roomsys.dao.RoleDao;
import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.domain.Role;
import edu.mum.roomsys.rest.RestGenericException;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public Iterable<Account> findAll() {
		return accountDao.findAll();
	}
	
	public Account findByUsername(String name) {
		return accountDao.findByUsername(name);
	}
	
	public Role findByRoleName(String name) {
		return roleDao.findByName(name);
	}

	@Transactional(value = TxType.REQUIRED)
	public Account createAccount(Account account) {
		if (account.getStudent() == null || account.getRole() == null) {
			throw new RestGenericException("Invalid parameters: Student email and/or role");
		}
		
		if (accountDao.findByEmail(account.getEmail()) != null) {
			throw new RestGenericException("Invalid parameters: Student existed");
		}
		return accountDao.save(account);
	}
}
