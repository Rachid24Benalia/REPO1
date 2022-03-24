package org.sid.wedding.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.sid.wedding.entities.Service;

@Repository
@Transactional(readOnly = true)
public class ServiceRepositoryImpl implements ServiceRepositoryCustom {
	  @PersistenceContext
	    EntityManager entityManager;
	  
	@SuppressWarnings("unchecked")
	@Override
	public List<Service> findServices(String type, String ville, int prix, int invites) {
		if(prix==0) {
			System.out.println("hello");
			 Query query = entityManager.createNativeQuery("SELECT * FROM Service as s " +
		                "WHERE s.type=? ", Service.class);
		        query.setParameter(1, type);
		        return query.getResultList();

		}else {
			 Query query = entityManager.createNativeQuery("SELECT * FROM Service as s " +
		                "WHERE s.type=? and s.ville=? and Budget_service<=? and nbr_invites_max<=?", Service.class);
		        query.setParameter(1, type);
		        query.setParameter(2, ville);
		        query.setParameter(3, prix);
		        query.setParameter(4, invites);
		        return query.getResultList();


		}
		

	}

}
