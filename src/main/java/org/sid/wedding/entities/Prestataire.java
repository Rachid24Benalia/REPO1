package org.sid.wedding.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Prestataire {
	@Id @GeneratedValue
	private Long IdPrestataire;
	public Prestataire(String nom, String prenom, String phone_number, String ville,
			String cin, String email,String nomEntreprise, String service, int experience,String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.phone_number = phone_number;
		this.ville = ville;
		this.cin = cin;
		this.email=email;
		this.nomEntreprise = nomEntreprise;
		this.service = service;
		this.experience = experience;
		this.adresse=adresse;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	private String nom;
	private String prenom;
    private String phone_number;
    private String ville;
	private String cin;
	private String nomEntreprise;
	private String service;
	private int experience;
	private String email;
	private String adresse;

	@OneToMany(mappedBy="prestataire")
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="prestataire")
	private Collection<Service> services;
	
	public Collection<Service> getServices() {
		return services;
	}
	public void setServices(Collection<Service> services) {
		this.services = services;
	}
	public Prestataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCin() {
		return cin;
	}



	public void setCin(String cin) {
		this.cin = cin;
	}



	public String getService() {
		return service;
	}



	public void setService(String service) {
		this.service = service;
	}



	public int getExperience() {
		return experience;
	}



	public void setExperience(int experience) {
		this.experience = experience;
	}



	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public Long getIdPrestataire() {
		return IdPrestataire;
	}
	public void setIdPrestataire(Long idPrestataire) {
		IdPrestataire = idPrestataire;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getPhone_number() {
		return phone_number;
	}




	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}




	public String getVille() {
		return ville;
	}




	public void setVille(String ville) {
		this.ville = ville;
	}




	public Collection<Reservation> getReservations() {
		return reservations;
	}




	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}


	

}
