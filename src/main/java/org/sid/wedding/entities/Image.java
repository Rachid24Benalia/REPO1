package org.sid.wedding.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image {
	
	@Id @GeneratedValue
	private Long idImage;
	private String chemain_image;
	@ManyToOne
	@JoinColumn(name="id_service",referencedColumnName="id_service")
    private Service service;
    private Boolean primaire;



	public Image(String chemain_image, Service service, Boolean primaire) {
		super();
		this.chemain_image = chemain_image;
		this.service = service;
		this.primaire = primaire;
	}


	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getChemain_image() {
		return chemain_image;
	}


	public void setChemain_image(String chemain_image) {
		this.chemain_image = chemain_image;
	}


	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Boolean getPrimaire() {
		return primaire;
	}
	public void setPrimaire(Boolean primaire) {
		this.primaire = primaire;
	}
	public Long getIdImage() {
		return idImage;
	}
	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}
	
	
}
  