package dev.hotel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.hotel.dto.CreateReservationDto;
import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.exception.CreerReservationException;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientRepository;
import dev.hotel.repository.ReservationRepository;
@Service
public class ReservationService {

private ReservationRepository reservationRepository;
private ChambreRepository chambreRepository;
private ClientRepository clientRepository;

	public ReservationService(ReservationRepository reservationRepository, ChambreRepository chambreRepository,
		ClientRepository clientRepository) {

	this.reservationRepository = reservationRepository;
	this.chambreRepository = chambreRepository;
	this.clientRepository = clientRepository;
}
	public ReservationService() {

		
	}
	public Reservation createReservation(CreateReservationDto createReservationDto) {
		
		List<String> messagesErreur = new ArrayList<>();
		
		Optional<Client> optClient = clientRepository.findByNumero(createReservationDto.getNumeroClient());
		if(optClient.isEmpty()) {
			messagesErreur.add("numéro client " + createReservationDto.getNumeroClient() + " non trouvé");
			
		}
		List<Chambre> chambresTrouvees = new ArrayList<>();
		
		for (String code : createReservationDto.getChambres()) {
            Optional<Chambre> optChambre = chambreRepository.findByCode(code);
            if (optChambre.isEmpty()) {
                messagesErreur.add("La chambre " + code + " n'existe pas");
            } else {
                chambresTrouvees.add(optChambre.get());
            }
            if (messagesErreur.isEmpty()) {
                Reservation reservation = new Reservation();
                reservation.setClient(optClient.get());
                reservation.setDateDebut(createReservationDto.getDateDebut());
                reservation.setDateFin(createReservationDto.getDateFin());
                reservation.setChambres(chambresTrouvees);
        }
			Reservation reservation = new Reservation();
		    return reservationRepository.save(reservation);
	}
		 throw new CreerReservationException(messagesErreur);
	}
}