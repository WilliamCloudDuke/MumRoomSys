package edu.mum.roomsys.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

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

	@Transactional(value = TxType.REQUIRED)
	public Account resetPassword(Account account) {
		Account current = accountDao.findOne(account.getId());

		if (current == null || !current.getEmail().equals(account.getEmail())) {
			throw new RestGenericException("Invalid parameters: Account email and/or id");
		}

		current.setPassword(passwordEncoder.encode(account.getPassword()));

		return accountDao.save(current);
	}

	public Account findAdminByBuildingNumber(int buildingNumber) {
		return accountDao.findAdminByBuildingNumber(buildingNumber);
	}
}
