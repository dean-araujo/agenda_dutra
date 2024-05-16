package com.deanaraujo.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deanaraujo.agenda.dto.ContactDto;
import com.deanaraujo.agenda.entity.ContactEntity;
import com.deanaraujo.agenda.mapper.ContactMapper;
import com.deanaraujo.agenda.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContactDto findById(@PathVariable Long id) {
		ContactEntity contactEntity = contactService.findById(id);
		ContactDto contactDto = ContactMapper.contactEntityToContactDto(contactEntity);
		return contactDto;
	}
}	
