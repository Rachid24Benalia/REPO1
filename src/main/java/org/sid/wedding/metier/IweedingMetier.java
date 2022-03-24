package org.sid.wedding.metier;


import java.util.List;

import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Prestataire;
import org.sid.wedding.entities.Service;
import org.sid.wedding.entities.Users;

public interface IweedingMetier {
	
	public void saveClient(String nom,String prenom,String email,
		String password,String phone,String ville,String cin,String gender);
	
	public void saveService(String name_service,int nbr_min,int nbr_max ,String Typeservice,String ville,double rating ,int budget,Long prestataire,String description);
	
	
  public void savePrestataire(String nom,String prenom,String email,
			  String password,String phone,String ville,String cin,
			  String Typeservice,String entreprise,int experience,String adresse);
  
  public void ReserverRendezVous(Client client,Prestataire prestataire,Service s,String date);
  public List<Service> getServices(String type, String ville, int prix, int invites);
  public List<Client> getClients();
  public List<Users> getUsers();
  public Service recupererService(Long id);

}
