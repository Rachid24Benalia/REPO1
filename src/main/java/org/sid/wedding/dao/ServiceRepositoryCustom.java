package org.sid.wedding.dao;

import java.util.List;

import org.sid.wedding.entities.Service;

public interface ServiceRepositoryCustom {
	public List<Service> findServices(String type,String ville,int prix,int invites);

}
