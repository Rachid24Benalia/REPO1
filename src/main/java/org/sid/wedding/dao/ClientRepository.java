package org.sid.wedding.dao;

import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
	
	public Client findByEmail(String email);

}
