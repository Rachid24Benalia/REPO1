package org.sid.wedding.dao;

import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
	public Users findByEmail(String email);

}
