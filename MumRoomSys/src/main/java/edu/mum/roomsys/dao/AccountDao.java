package edu.mum.roomsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.roomsys.domain.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {
	public Account findByUsername(String username);

	public Account findByEmail(String email);

	@Query("select a from Account a where a.username like %:buildingNumber% ")
	public Account findAdminByBuildingNumber(@Param("buildingNumber") int buildingNumber);

}
