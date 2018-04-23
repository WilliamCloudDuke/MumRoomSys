package edu.mum.roomsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.roomsys.domain.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{
	public Role findByName(String name);
}
