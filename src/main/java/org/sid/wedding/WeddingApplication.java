package org.sid.wedding;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sid.wedding.dao.ClientRepository;
import org.sid.wedding.dao.ImageRepository;
import org.sid.wedding.dao.PackRepository;
import org.sid.wedding.dao.PrestataireRepository;
import org.sid.wedding.dao.ReservationRepository;
import org.sid.wedding.dao.ServiceRepository;
import org.sid.wedding.dao.UserRepository;
import org.sid.wedding.dao.WIshListRepository;
import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Image;
import org.sid.wedding.entities.Pack;
import org.sid.wedding.entities.Prestataire;
import org.sid.wedding.entities.Reservation;
import org.sid.wedding.entities.Service;
import org.sid.wedding.entities.Users;
import org.sid.wedding.entities.WishList;

@SpringBootApplication
public class WeddingApplication implements CommandLineRunner {
	   @Autowired
	     private ClientRepository clientRepository;
	   @Autowired
	   private PasswordEncoder passwordEncoder;
	   @Autowired
	     private PrestataireRepository prestataireRepository;
	   @Autowired
	     private UserRepository userRepo;
	   @Autowired
	     private ServiceRepository serviceRepo;
	   
	   @Autowired
	     private PackRepository packRepo;
		@Autowired 
		private WIshListRepository wishlist;
	   @Autowired
	     private ImageRepository imageRepository;
	   @Autowired
        private ReservationRepository reservation;
	public static void main(String[] args) {
		SpringApplication.run(WeddingApplication.class, args);
	 
	}

	@Override
	public void run(String... args) throws Exception {

       Client c1=new Client("assiar","nouheil","06129876","rabat","AEIY3","nouheila.assiar@yahoo.fr","f");
       
       Client c3=new Client("assiar","nouheila","0640875462","Rabat","EE98754","assiar.nouheila212@gmail.com","Mariée");
       clientRepository.save(c3);
       
       Users u4=new Users("assiar.nouheila212@gmail.com",passwordEncoder.encode("12345"),false,"CLIENT");
	   userRepo.save(u4);
	   
	   System.out.println(c1);
	   clientRepository.save(c1);
	  
	   
	   Client c2=new Client("assiar","ilyas","06129876","rabat","AEIY3","ilyas.assiar@gmail.com","f");
	   System.out.println(c2);
	   clientRepository.save(c2);
	   
	   Users u1=new Users("nouheila.assiar@yahoo.fr",passwordEncoder.encode("nouha"),true,"ADMIN");
	   userRepo.save(u1);
	   
	   Users u2=new Users("ilyas.assiar@gmail.com",passwordEncoder.encode("ilyas"),true,"CLIENT");
	   userRepo.save(u2);
	   
	   Users u3=new Users("benalia.rachid@ensam-casa.ma",passwordEncoder.encode("12345"),true,"ADMIN");
	   userRepo.save(u3);
	   
	   
	   Users u5 = new Users("adib.zineb@gmail.com",passwordEncoder.encode("12345678"),true,"PRESTATAIRE");
	   userRepo.save(u5);  
	   
	 
	   Prestataire p1=new Prestataire("adib","zineb","0650986","tanger",
			   "AZ48970","adib.zineb@gmail.com","ADIBZ","neggafa",13,"Agdal,rue fal oueld omar");
	   prestataireRepository.save(p1);
	   
     

	   List <Image> images=new ArrayList<Image>();
	   List <Image> images0=new ArrayList<Image>();
	   List <Image> images2=new ArrayList<Image>();
	   List <Image> images3=new ArrayList<Image>();

	   Service s=new Service(1000,"un service parfait","palais ramssis","neggafa",1234,"Rabat",2.9,images,p1,100);
	   Service s1=new Service(2000,"un service parfait","palais ramssis","neggafa",1234,"Rabat",2.9,images,p1,100);
	   Service s2=new Service(10000,"un service parfait","palais ramssis","neggafa",1234,"Rabat",2.9,images,p1,100);
	   Service s3=new Service(10000,"un service parfait","palais ramssis","neggafa",1234,"Casablanca",2.9,images,p1,200);
       
	   
	   
	   serviceRepo.save(s);
	   serviceRepo.save(s1);
	   serviceRepo.save(s2);
	   serviceRepo.save(s3);

	  

	   Image i=new Image("/assets/slide2.jpeg",s,true);
	   Image i1=new Image("/assets/2.jpg",s,false);
	   Image i4=new Image("/assets/3.jpg",s,false);
	   
	   images0.add(i);
	   images0.add(i1);
	   images0.add(i4);
	   
	   imageRepository.save(i);
	   imageRepository.save(i1);
	   imageRepository.save(i4);
	   
       s.setImages(images0);
       serviceRepo.save(s);

       
	   Image i2=new Image("/assets/slide1.jpeg",s2,true);
	   imageRepository.save(i2);
        images2.add(i2);
        s2.setImages(images2);
        serviceRepo.save(s2);
       List<Service> services=new ArrayList<Service>();
       services.add(s3);
       services.add(s);
        Pack p=new Pack(60000,services,178,765,"Primary");
        packRepo.save(p);
	   Image i3=new Image("/assets/slide3.jpeg",s3,true);
	   imageRepository.save(i3);
       images2.add(i3);
       s2.setImages(images3);
       serviceRepo.save(s3);
       
       
	   Image i0=new Image("/assets/2.jpg",s1,true);
	   imageRepository.save(i0);
       images.add(i0);
       s2.setImages(images);
       serviceRepo.save(s1);
       
	   
       List<Service> serv=new ArrayList<Service>();
       serv.add(s);
       serv.add(s3);
       serv.add(s1);
       

	  //Creation d'un pack
       Pack pa=new Pack(10000,serv,400,5,"primare");
       packRepo.save(pa);
	   
       Date date = new Date();

       long timeInMilliSeconds = date.getTime();
       java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
       Reservation r=new Reservation(c2,p1,s1,date1);
       reservation.save(r);
       
       WishList w=new WishList(c2,s1);
       wishlist.save(w);

	}

}



