package org.sid.wedding.metier; 


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.sid.wedding.dao.ClientRepository;
import org.sid.wedding.dao.ImageRepository;
import org.sid.wedding.dao.UserRepository;
import org.sid.wedding.dao.PrestataireRepository;
import org.sid.wedding.dao.ReservationRepository;
import org.sid.wedding.dao.ServiceRepository;
import org.sid.wedding.dao.UserRepository;
import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Image;
import org.sid.wedding.entities.Prestataire;
import org.sid.wedding.entities.Reservation;
import org.sid.wedding.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WeedingMetierImp implements IweedingMetier {
	 @Autowired
	   private PasswordEncoder passwordEncoder;
	 
	 @Autowired
	   private UserRepository userRepository;
	 
	  @Autowired
      private ClientRepository clientRepository;
	  
	  @Autowired 
	  private ImageRepository imagerepo;
	  
	  @Autowired
      private PrestataireRepository prestataireRepository;
	  
	  @Autowired
      private ReservationRepository reservationRepository;
	  
	  @Autowired
      private UserRepository userepository;
	  

	  @Autowired
      private ServiceRepository serviceRepository;
	  //@Autowired
	 // private ReservationRepository reservationRepository;
	  
		@Override
		public void saveClient(String nom, String prenom, String email, String password, String phone, String ville,
				String cin,String gender) 
		{
		  Users u=new Users(email,passwordEncoder.encode(password),false,"CLIENT");
		  userepository.save(u);
		 Client c=new Client(nom,prenom,phone,ville,cin,email,gender);
	     clientRepository.save(c);			
		}
		
		@Override
		public void savePrestataire(String nom,String prenom,String email,
				  String password,String phone,String ville,String cin,
				  String Typeservice,String entreprise,int experience,String adresse) {
			
			  Users u=new Users(email,passwordEncoder.encode(password),false,"PRESTATAIRE");
			  userepository.save(u);
			  
			  Prestataire p=new Prestataire(nom,prenom,phone,ville,
					   cin,email,entreprise,Typeservice,experience,adresse);	
			  
			  prestataireRepository.save(p);
		}

		@Override
		public void ReserverRendezVous(Client client,Prestataire prestataire,org.sid.wedding.entities.Service s,String date) {
			System.out.print(date);
			 Date datec=Date.valueOf(date);
			Reservation r=new Reservation(client,prestataire,s,datec) ;
			reservationRepository.save(r);
		}

		@Override
		public List<org.sid.wedding.entities.Service> getServices(String type, String ville, int prix, int invites) {
			List<org.sid.wedding.entities.Service> services=serviceRepository.findServices(type,ville,prix,invites);
			return services;
		}
		
		@Override
		public List<org.sid.wedding.entities.Client> getClients(){
			List<org.sid.wedding.entities.Client> clients= clientRepository.findAll();
			return clients;
		}
		@Override
		public List<org.sid.wedding.entities.Users> getUsers(){
			List<org.sid.wedding.entities.Users> users= userRepository.findAll();
			return users;
		}
		
		@Override
		public org.sid.wedding.entities.Service recupererService(Long id) {
			return serviceRepository.findById(id).get();
		}
		
		@Override
		public void saveService(String name_service, int nbr_min, int nbr_max, String Typeservice, String ville,
				double rating, int budget, Long prestataire,String description) {
			Prestataire p= prestataireRepository.findById(prestataire).get();
			   List <Image> images=new ArrayList<Image>();
			   org.sid.wedding.entities.Service s=new org.sid.wedding.entities.Service(budget,description, name_service,Typeservice, nbr_min,nbr_max, ville,rating,images, p);
				serviceRepository.save(s);
			   Image i=new Image("/assets/slide4.jpeg",s,false);
			   Image i1=new Image("/assets/2.jpg",s,false);
			   Image i2=new Image("/assets/10.jpg",s,false);
              images.add(i1);
              images.add(i2);
			   images.add(i);
			   imagerepo.save(i);
			   imagerepo.save(i1);
			   imagerepo.save(i2);

			   s.setImages(images);
				serviceRepository.save(s);

			// TODO Auto-generated method stub
			
		}


}
