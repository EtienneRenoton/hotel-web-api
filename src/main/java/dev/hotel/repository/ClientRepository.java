package dev.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import dev.hotel.entite.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	Optional<Client> findByNumero(String numero);
}
