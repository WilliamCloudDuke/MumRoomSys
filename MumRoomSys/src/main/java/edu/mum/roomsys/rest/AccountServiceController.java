package edu.mum.roomsys.rest;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.roomsys.domain.Account;
import edu.mum.roomsys.dto.AccountDto;
import edu.mum.roomsys.service.AccountService;
import edu.mum.roomsys.service.StudentService;

@Controller
public class AccountServiceController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AccountService accountService;	

	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value = { "/api/accounts" }, method = { RequestMethod.GET })
	@ResponseBody
	public Iterable<Account> getAllAccount() {
		return accountService.findAll();
	}
	
	@RequestMapping(value = { "/api/accounts" }, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public AccountDto createAccount(@RequestBody AccountDto accountDto) throws ParseException {
        Account account = convertToEntity(accountDto);
        Account accountCreated = accountService.createAccount(account);
        return convertToDto(accountCreated);
    }

	private AccountDto convertToDto(Account account) {
		AccountDto acctDto = modelMapper.map(account, AccountDto.class);
		acctDto.setStudentRole(account.getRole().getName());
		return acctDto;
	}	
	
	private Account convertToEntity(AccountDto accountDto) throws ParseException {
		Account acct = modelMapper.map(accountDto, Account.class);
		acct.setStudent(studentService.findByEmail(accountDto.getEmail()));
		acct.setRole(accountService.findByRoleName(accountDto.getStudentRole()));
		return acct;
	}	

}
