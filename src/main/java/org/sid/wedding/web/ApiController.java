package org.sid.wedding.web;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.sid.wedding.dao.ReservationRepository;
import org.sid.wedding.dao.ServiceRepository;
import org.sid.wedding.entities.Prestataire;
import org.sid.wedding.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api",produces={ "application/json"},method=RequestMethod.GET)
public class ApiController {
	
	@Autowired 
	private ReservationRepository reservationRepository;
	
	
	@Autowired 
	private ServiceRepository serviceRe;
	

	
	@GetMapping(value="/mi")
	public List<String> mi(@RequestParam("id") Long id) {
		
		//recuperer les dates les  reservations de la base de données
		List<String> dates=new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
	     //on recupere les reservations concernat le prestataire de service choisie
	     Prestataire p=serviceRe.findById(id).get().getPrestataire();
		 List <Reservation> reservations=reservationRepository.findByPrestataire(p);
		 System.out.print(reservations);
		 for(Reservation reservation:reservations) {
			String x=dateFormat.format(reservation.getDate()).split("-",2)[1];
			
			 if(!x.contains("10-")  &&  !x.contains("11-") &&  !x.contains("12-")) {
			     x=dateFormat.format(reservation.getDate()).split("-",2)[1].substring(1);
			 }
	          dates.add(x);
         
		 }
		 return dates;
	}

}
