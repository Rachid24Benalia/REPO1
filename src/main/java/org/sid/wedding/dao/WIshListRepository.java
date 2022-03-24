package org.sid.wedding.dao;

import java.util.List;

import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Service;
import org.sid.wedding.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WIshListRepository extends JpaRepository<WishList,Long>{
	public List<WishList> findByClient(Client client);
	public WishList findByService(Service s);

}
