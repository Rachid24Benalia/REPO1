package org.sid.wedding.dao;

import org.sid.wedding.entities.Prestataire;
import org.sid.wedding.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestataireRepository extends JpaRepository<Prestataire,Long>{
	public Prestataire findByEmail(String email);
}
