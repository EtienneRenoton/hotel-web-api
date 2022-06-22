package dev.hotel.dto;

import javax.validation.constraints.NotBlank;

import dev.hotel.entite.Client;

public class ClientDto {
	
	private String nom;
	private String premons;
	private String numero;
	
	public static ClientDto from (Client client)  {
		return new ClientDto(client.getNom(), client.getPrenoms(), client.getNumero());
	}
	
	public ClientDto() {
		
	}

	public ClientDto(String nom, String premons, String numero) {
		this.nom = nom;
		this.premons = premons;
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPremons() {
		return premons;
	}

	public void setPremons(String premons) {
		this.premons = premons;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
