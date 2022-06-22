package dev.hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.dto.ClientDto;
import dev.hotel.dto.CreateClientDto;
import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

import dev.hotel.service.ClientSrv;

@RestController
@RequestMapping ("clients")
public class ClientController {
	
	private ClientSrv clientSrv;
	
	public ClientController(ClientSrv clientSrv) {
		this.clientSrv = clientSrv;
	}


	//	GET /clients?start=X&size=Y
		/**
		 * Sans l'utilsation de Dto.
		 * 
		public List<Client> listAll(@RequestParam Integer start, @RequestParam Integer size) {
			return this.clientSrv.findAll(start, size);
		}
		 
		*Ici on utilise ClientDto précédament créer pour utiliser les paramètres que l'on souhaite.
		*/
		public List <ClientDto> listAll(@RequestParam Integer start, @RequestParam Integer size) {
			return this.clientSrv
					.findAll(start,size)
					.stream().map(ClientDto::from)
					.toList();
					
		} 
		
		@GetMapping("{numero}")
		public ResponseEntity<?> findByNumero(@PathVariable String numero) {
			Optional<Client> optClient = this.clientSrv.findByNumero(numero);
			if (optClient.isPresent()) {
				Client clientTrouve = optClient.get();
				return ResponseEntity.ok(ClientDto.from(clientTrouve));
			} else {
				return ResponseEntity.notFound().build();
			}
			}
		@PostMapping
	    public ResponseEntity<?> createClient(@RequestBody CreateClientDto createClientDto) {
	        if (StringUtils.isBlank(createClientDto.getNom())
	                || StringUtils.isBlank(createClientDto.getPrenoms())
	                || createClientDto.getNom().length() < 2 || createClientDto.getPrenoms().length() < 2) {
	            return ResponseEntity.badRequest().body("Le nom et les prénoms doivent avoir 2 caractères minimum");
	        }
	        Client clientCree = this.clientSrv.createClient(createClientDto.getNom(), createClientDto.getPrenoms());
	        return ResponseEntity.ok(clientCree);
	    }
}
