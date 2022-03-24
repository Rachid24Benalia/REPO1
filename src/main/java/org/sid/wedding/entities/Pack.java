package org.sid.wedding.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pack {
	@Id @GeneratedValue
	private Long idPack;
   private int budgetPacket;
   private String type;
	public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
	@OneToMany(mappedBy="pack")
   private Collection<Service> services;
	
   private int nbrInvites;
   private int nbrFeatures;
public int getBudgetPacket() {
	return budgetPacket;
}
public void setBudgetPacket(int budgetPacket) {
	this.budgetPacket = budgetPacket;
}
public Collection<Service> getServices() {
	return services;
}
public void setServices(Collection<Service> services) {
	this.services = services;
}
public int getNbrInvites() {
	return nbrInvites;
}
public void setNbrInvites(int nbrInvites) {
	this.nbrInvites = nbrInvites;
}
public int getNbrFeatures() {
	return nbrFeatures;
}
public void setNbrFeatures(int nbrFeatures) {
	this.nbrFeatures = nbrFeatures;
}
public Pack(int budgetPacket, Collection<Service> services, int nbrInvites, int nbrFeatures,String type) {
	super();
	this.budgetPacket = budgetPacket;
	this.services = services;
	this.nbrInvites = nbrInvites;
	this.nbrFeatures = nbrFeatures;
	this.type=type;
}
public Long getIdPack() {
	return idPack;
}
public void setIdPack(Long idPack) {
	this.idPack = idPack;
}
   
   
}
