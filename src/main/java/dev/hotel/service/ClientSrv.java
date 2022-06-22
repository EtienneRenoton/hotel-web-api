package dev.hotel.service;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

@Service
public class ClientSrv {

	private ClientRepository clientRepo;

	public ClientSrv(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}
	@Transactional
	public Client createClient(String nom, String prenoms) {
	    // règle de génération d'un numéro de client
	    Client client = new Client();
	    client.setNom(nom);
	    client.setPrenoms(prenoms);
	    String numero = "C-" + RandomStringUtils.randomAlphanumeric(10);
	    client.setNumero(numero);

	    return clientRepo.save(client);

	}
	
	public List<Client> findAll(Integer start, Integer size){
		return this.clientRepo.findAll(PageRequest.of(start, size)).toList();
	}
	
	public Optional<Client> findByNumero(String numero){
		return this.clientRepo.findByNumero(numero);
	}
	
}
