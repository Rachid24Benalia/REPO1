package org.sid.wedding.dao;

import java.util.List;

import org.sid.wedding.entities.Client;
import org.sid.wedding.entities.Prestataire;
import org.sid.wedding.entities.Reservation;
import org.sid.wedding.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
	public List<Reservation> findByPrestataire(Prestataire prestataire);
	public List<Reservation> findByService(Service service);
	public List<Reservation> findByClient(Client client);

}
