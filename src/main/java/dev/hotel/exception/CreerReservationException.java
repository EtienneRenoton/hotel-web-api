package dev.hotel.exception;

import java.util.List;

public class CreerReservationException extends RuntimeException {
	
	private final List<String> erreurs;

	public CreerReservationException(List<String> messagesErreur) {
		this.erreurs = messagesErreur;
	}

	public List<String> getErreurs() {
		return erreurs;
	}
}
