package org.sid.wedding.web;



import java.util.ArrayList;
import java.util.List;

import org.sid.wedding.dao.ClientRepository;
import org.sid.wedding.dao.PrestataireRepository;
import org.sid.wedding.dao.ReservationRepository;
import org.sid.wedding.dao.ServiceRepository;
import org.sid.wedding.dao.UserRepository;
import org.sid.wedding.dao.WIshListRepository;
import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Prestataire;
import org.sid.wedding.entities.Reservation;
import org.sid.wedding.entities.Service;
import org.sid.wedding.entities.Users;
import org.sid.wedding.entities.WishList;
import org.sid.wedding.metier.IweedingMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class WeddingController {
	//le model est generalement utilisé lorsqu'on veut envoyer des elements à la page html
	@Autowired
	private IweedingMetier weedingMetier;
	@Autowired 
	private ClientRepository clientRepository;
	
	private int s1=0,s2=0;
	
	@Autowired 
	private PrestataireRepository prestataireRepo,prestataireRepository;
	@Autowired 
	private UserRepository userRepository,Usertrepo;

	@Autowired 
	private ServiceRepository serviceRe;
	
	@Autowired 
    private ReservationRepository reservation;
	@Autowired 
	private WIshListRepository wishlist;
	
	@RequestMapping("/index")
	public String index() {
	
		return "index";
	}

	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping(value="saveService",method=RequestMethod.POST)
	  public String saveService(Model model,String name_service,int nbr_min,int nbr_max ,String Typeservice,String ville,double rating ,int budget,Long prestataire,String description) {
		  
		  weedingMetier.saveService(name_service,nbr_min,nbr_max,Typeservice,ville,rating,budget,prestataire,description);
		  return "redirect:/profil";
	  }
	
	@RequestMapping("/addServicepre")
	public String ajouterSer(Model model) {
		 String email=SecurityContextHolder.getContext().getAuthentication().getName();
		  Prestataire p=prestataireRepo.findByEmail(email);
  		  model.addAttribute("presta",p);
		return "addServicepre";
	}
	
	@RequestMapping("/registerClient")
	public String registerClient() {
		return "regiterClient";
	}
	@RequestMapping("/registerPrestataire")
	public String registerPresatatire() {
		return "registerPrestataire";
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(@RequestParam("idService") Long idService,Model model) {
		System.out.print(idService);
		Service s=weedingMetier.recupererService(idService);
		model.addAttribute("service",s);
		return "detailService";
	}
	
	@RequestMapping(value="/services")
	public String services(@RequestParam("type") String type,@RequestParam("ville") String ville,@RequestParam("invite") int invite,@RequestParam("prix") int prix,Model model) {
		
		model.addAttribute("type",type);
		List<Service> services=weedingMetier.getServices(type,ville,prix,invite);
		if(services.size()==0) {
			model.addAttribute("noResult","There is no result");
		}
		model.addAttribute("services",services);
		return "services";
	}
	@RequestMapping("/admin")
	public String admin(Model model) {
		List<Users> users= weedingMetier.getUsers();
		List<Client> clients= new ArrayList<Client>();
		s1=0;
		s2=0;
		users.forEach(u->{
			boolean ac = u.getActive();
		    String cl = u.getRole();
			if(ac && cl.equals("CLIENT") ) {
				Client c = clientRepository.findByEmail(u.getUsername());
				clients.add(c);
				s1= s1 + 1;
			}
			if(ac && cl.equals("PRESTATAIRE")) {
				s2=s2+1;
			}
			
		 
		});
		model.addAttribute("clients",clients); 
		System.out.print(s1);
		model.addAttribute("somme",s1);
		model.addAttribute("somme2",s2);
		return "admin";
	}
	@RequestMapping("/client")
	public String client(Model model) {
		List<Users> users= weedingMetier.getUsers();
		List<Client> clients= new ArrayList<Client>();
		users.forEach(u->{
			boolean ac = u.getActive();
		    String cl = u.getRole();
			if(ac && cl.equals("CLIENT") ) {
				Client c = clientRepository.findByEmail(u.getUsername());
				clients.add(c);
			}
		 
		});
		model.addAttribute("clients",clients);
		return "client";
	}
	@RequestMapping("/usersClient")
	public String usersClient(Model model) {
		List<Users> users= weedingMetier.getUsers();
		List<Client> clients= new ArrayList<Client>();
		users.forEach(u->{
			boolean ac = u.getActive();
			
		    String cl = u.getRole();
			if(!u.getActive() && cl.equals("CLIENT") ) {
				Client c = clientRepository.findByEmail(u.getUsername());
				clients.add(c);
			}
		 
		});
		
		model.addAttribute("clients",clients);
		return "usersClient";
	}
	
	@RequestMapping("/prestataire")
	public String prestataire(Model model) {
		List<Users> users= weedingMetier.getUsers();
		List<Prestataire> prs = new ArrayList< Prestataire>();
		users.forEach(u->{
			boolean ac = u.getActive();
		    String cl = u.getRole();
			if(ac && cl.equals("PRESTATAIRE") ) {
				Prestataire p = prestataireRepository.findByEmail(u.getUsername());
				prs.add(p);
			}
		 
		});
		model.addAttribute("prestataires",prs);
		return "prestataire";
		
	}
	
	@RequestMapping("/prestataireNon")
	public String nonPrestataire(Model model) {
		List<Users> users= weedingMetier.getUsers();
		List<Prestataire> prs = new ArrayList< Prestataire>();
		users.forEach(u->{
			boolean ac = u.getActive();
		    String cl = u.getRole();
			if(!ac && cl.equals("PRESTATAIRE") ) {
				Prestataire p = prestataireRepository.findByEmail(u.getUsername());
				prs.add(p);
			}
		 
		});
		model.addAttribute("prestataires",prs);
		return "nonPrestataire";
	}
	
	@RequestMapping(value="/activeruser")
	public String activerUser(@RequestParam("email") String email, Model model) {
		Users user = userRepository.findByEmail(email);
		user.setRole(true);
		userRepository.save(user);
		return "admin";
	}
	@RequestMapping(value="/service")
	public String services(Model model) {
		String type="neggafa";
		int prix=0;
		int invite=0;
		String ville="rabat";
		model.addAttribute("type",type);
		List<Service> services=weedingMetier.getServices(type,ville,prix,invite);
		model.addAttribute("services",services);
		return "services";
	}
	
	
	
	@RequestMapping("/profilClient")
	public String profilc(Model model) {
		 String email=SecurityContextHolder.getContext().getAuthentication().getName();
		 Client c=clientRepository.findByEmail(email);
		 //il faut ajouter les reservatios du client
		 List<Reservation> res=reservation.findByClient(c);
		 List<WishList> wishes=wishlist.findByClient(c);
		 //il faut ajouter les wishList du client
		 model.addAttribute("reservations",res);
		 model.addAttribute("wishes",wishes);
		  model.addAttribute("client",c);
		  model.addAttribute("email",email);
		
		return "profilClient";
		  
	}
	
	@RequestMapping("/profil")
    public String profil(Model model) {
		 String email=SecurityContextHolder.getContext().getAuthentication().getName();
          Users u=Usertrepo.findByEmail(email);
          
          //ensuite verifier  le role du user
          if(u.getRole().equals("CLIENT")) {
        	  Client c=clientRepository.findByEmail(email);
     		 //il faut ajouter les reservatios du client
     		 List<Reservation> res=reservation.findByClient(c);
     		 List<WishList> wishes=wishlist.findByClient(c);
     		 //il faut ajouter les wishList du client
     		 model.addAttribute("reservations",res);
     		 model.addAttribute("wishes",wishes);
     		  model.addAttribute("client",c);
     		  model.addAttribute("email",email);
     		  System.out.print(c);
      		return "profilClient";
        	  
          }else if(u.getRole().equals("PRESTATAIRE")){
        	  Prestataire p=prestataireRepo.findByEmail(email);
      		 //il faut recuperer les reservations concer
      		// List<Reservation> res=reservation.findByClient(c);
      		// List<WishList> wishes=wishlist.findByClient(c);
      		 //il faut ajouter les wishList du client
      		// model.addAttribute("reservations",res);
      		// model.addAttribute("wishes",wishes);
      		  model.addAttribute("presta",p);
        	  return "profilPrestataire";
          }else if(u.getRole().equals("ADMIN")) {
        	  return "admin";
          }else {
     
        	  return "index";
          }
	}
	 
	 @RequestMapping(value="/saveDate",method=RequestMethod.POST)
	  public String saveDate(Model model,String date,Long id)  
	  { //id:id de service reserve

		 String email=SecurityContextHolder.getContext().getAuthentication().getName();
		 Client c=clientRepository.findByEmail(email);
		 Service s=serviceRe.findById(id).get();	  
		weedingMetier.ReserverRendezVous(c, s.getPrestataire(),s,date);
		 return "redirect:/index";  
	  }
	
	
	  @RequestMapping(value="/saveClient",method=RequestMethod.POST)
	  public String saveClient(Model model,String nom,String prenom,String email,
			  String password,String phone,String ville,String cin,String gender)  
	  {
		  weedingMetier.saveClient(nom, prenom, email, password, phone, ville, cin,gender);
 		  return "redirect:/login";	  
	  }
	  @RequestMapping(value="/savePrestataire",method=RequestMethod.POST)
	  public String savePrestataire(Model model,String nom,String prenom,String email,
			  String password,String phone,String ville,String cin,
			  String Typeservice,String entreprise,int experience,String adresse)  {
		  weedingMetier.savePrestataire(nom, prenom, email, password, phone, ville,cin,Typeservice,entreprise,experience,adresse);
 		  return "redirect:/login";	
	  }
	  
	
	  


	

}
