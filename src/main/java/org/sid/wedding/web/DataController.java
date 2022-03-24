package org.sid.wedding.web;




import org.sid.wedding.dao.ClientRepository;
import org.sid.wedding.dao.ServiceRepository;
import org.sid.wedding.dao.WIshListRepository;
import org.sid.wedding.entities.Client;

import org.sid.wedding.entities.Service;
import org.sid.wedding.entities.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/ap",produces={ "application/json"},method=RequestMethod.GET)

public class DataController {	
	
	@Autowired WIshListRepository wishlist;
	
	@Autowired 
	private ServiceRepository serviceRe;
	
	@Autowired 
	private ClientRepository clientrepo;

	@GetMapping(value="/wish") 
	public void wish(@RequestParam("id") Long id,@RequestParam("flag") String flag) {
		 String email=SecurityContextHolder.getContext().getAuthentication().getName();
		 Client c=clientrepo.findByEmail(email);
		Service s=serviceRe.findById(id).get();
		if(flag.equals("ok")) {
			//client+service
		    WishList w=new WishList(c,s);
			wishlist.save(w);
		}else {
			WishList w=wishlist.findByService(s);
			wishlist.delete(w);
		}
		
	}


}
