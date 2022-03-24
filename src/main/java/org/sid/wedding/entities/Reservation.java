package org.sid.wedding.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reservation {
	@Id @GeneratedValue
	 private Long id_reservation;
	
	@ManyToOne
	@JoinColumn(name="id_client",referencedColumnName="IdClient")
	 private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_presatataire",referencedColumnName="IdPrestataire")
	 private Prestataire prestataire;
	
	@ManyToOne
	@JoinColumn(name="id_service",referencedColumnName="Id_service")
	private Service service;
	
	 public Reservation(Client client, Prestataire prestataire, Service service, Date date) {
		super();
		this.client = client;
		this.prestataire = prestataire;
		this.service = service;
		this.date = date;
	}
	public Long getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(Long id_reservation) {
		this.id_reservation = id_reservation;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	//la date de reservation
	 private Date date;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id_reservation;
	}
	public void setId(Long id) {
		this.id_reservation = id;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}
	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
