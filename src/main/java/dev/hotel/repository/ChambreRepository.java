package dev.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Integer>{
	  Optional<Chambre> findByCode(String code);
}
