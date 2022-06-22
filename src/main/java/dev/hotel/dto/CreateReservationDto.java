package dev.hotel.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dev.hotel.entite.Reservation;

public class CreateReservationDto {
	@FutureOrPresent
	  private LocalDate dateDebut;
	@Future
	  private LocalDate dateFin;
	@NotBlank
	  private String numeroClient;
	@Size(min=1)
	  private List<String> chambres;
	  
	  
	  
	public CreateReservationDto() {
	}
	
	public CreateReservationDto(LocalDate dateDebut, LocalDate dateFin, String numeroClient, List<String> chambres) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.numeroClient = numeroClient;
		this.chambres = chambres;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public String getNumeroClient() {
		return numeroClient;
	}
	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}
	public List<String> getChambres() {
		return chambres;
	}
	public void setChambres(List<String> chambres) {
		this.chambres = chambres;
	}
}
