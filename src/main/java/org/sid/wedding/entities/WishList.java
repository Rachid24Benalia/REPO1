package org.sid.wedding.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishList {
	@Id @GeneratedValue
	private Long id_wish;
	@ManyToOne
	@JoinColumn(name="id_client",referencedColumnName="IdClient")
   private Client client;
	@ManyToOne
	@JoinColumn(name="id_service",referencedColumnName="id_service")
   private Service service;
	
	public WishList(Client client, Service service) {
		super();
		this.client = client;
		this.service = service;
	}
	public WishList() {
		super();
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	
   
}
