package com.deanaraujo.agenda.exception;

public class ContactNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContactNotFoundException(String message) {
		super(message);
	}
}