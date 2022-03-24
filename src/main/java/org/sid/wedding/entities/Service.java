package org.sid.wedding.entities;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Service {
    /**
	 * 
	 */
	
	@Id @GeneratedValue
	private Long id_service;
    private int Budget_service;
    private String description;
    private String nom_service;
    private String type;
    private int nbr_invites_min;
    private int nbr_invites_max;
    private String ville;
    private double rating;
    
    @OneToMany(mappedBy="service")
	private Collection<Image> images;
    
    @OneToMany(mappedBy="service")
	private Collection<WishList> wishes;
    
    public Service(int budget_service, String description, String nom_service, String type, int nbr_invites_min,
			int nbr_invites_max, String ville, double rating, Collection<Image> images,
			Prestataire prestataire) {
		super();
		Budget_service = budget_service;
		this.description = description;
		this.nom_service = nom_service;
		this.type = type;
		this.nbr_invites_min = nbr_invites_min;
		this.nbr_invites_max = nbr_invites_max;
		this.ville = ville;
		this.rating = rating;
		this.images = images;
		this.prestataire = prestataire;
	}


	@ManyToOne
   	@JoinColumn(name="id_pack",referencedColumnName="idPack")
    private Pack pack;
    //le prestataire qui a lancé le service
    @ManyToOne
	@JoinColumn(name="id_prestataire",referencedColumnName="IdPrestataire")
    private Prestataire prestataire;
    
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	

	public String getService_type() {
		return type;
	}

	public void setService_type(String service_type) {
		this.type = service_type;
	}



	public int getNbr_invites_min() {
		return nbr_invites_min;
	}

	public void setNbr_invites_min(int nbr_invites_min) {
		this.nbr_invites_min = nbr_invites_min;
	}

	public int getNbr_invites_max() {
		return nbr_invites_max;
	}

	public void setNbr_invites_max(int nbr_invites_max) {
		this.nbr_invites_max = nbr_invites_max;
	}

	public Collection<WishList> getWishes() {
		return wishes;
	}

	public void setWishes(Collection<WishList> wishes) {
		this.wishes = wishes;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}



	public Service(int budget_service, String description, String nom_service, String service_type, int nbr_invites,
			String ville, double rating, Collection<Image> images, Prestataire prestataire,int nbr_invites_max) {
		super();
		Budget_service = budget_service;
		this.description = description;
		this.nom_service = nom_service;
		this.type = service_type;
		this.nbr_invites_min = nbr_invites;
		this.ville = ville;
		this.rating = rating;
		this.images = images;
		this.prestataire = prestataire;
	    this.nbr_invites_max=nbr_invites_max;

	}

	public Long getId_service() {
		return id_service;
	}
	public void setId_service(Long id_service) {
		this.id_service = id_service;
	}
	public double getBudget_service() {
		return Budget_service;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom_service() {
		return nom_service;
	}
	public void setNom_service(String nom_service) {
		this.nom_service = nom_service;
	}

	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	public void setBudget_service(int budget_service) {
		Budget_service = budget_service;
	}
    
    
}