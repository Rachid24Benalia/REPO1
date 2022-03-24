package org.sid.wedding.dao;


import org.sid.wedding.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long>,ServiceRepositoryCustom{
	
	
}
