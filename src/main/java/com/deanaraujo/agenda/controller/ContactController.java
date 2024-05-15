package com.deanaraujo.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deanaraujo.agenda.entity.ContactEntity;
import com.deanaraujo.agenda.repository.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContactEntity searchContactById(@PathVariable Long id) {
		return contactRepository.searchById(id).get();
	}
}	
