package org.sid.wedding.entities;



import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Client  {

	@Id @GeneratedValue
	private Long IdClient;
	private String nom;
	private String prenom;
    private String phone_number;
    private String ville;
	private String cin;
	private String email;
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(mappedBy="client")
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="client")
	private Collection<WishList> wishes;
	
	private String sexe;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(String nom, String prenom, String phone_number, String ville,
			String cin, String email,String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.phone_number = phone_number;
		this.ville = ville;
		this.cin = cin;
		this.email=email;
		this.sexe = sexe;
	}


	public Long getIdClient() {
		return IdClient;
	}


	public void setIdClient(Long idClient) {
		IdClient = idClient;
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


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}


	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
}
