package com.deanaraujo.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deanaraujo.agenda.dto.ContactDto;
import com.deanaraujo.agenda.entity.ContactEntity;
import com.deanaraujo.agenda.exception.ContactNotFoundException;
import com.deanaraujo.agenda.mapper.ContactMapper;
import com.deanaraujo.agenda.mapper.ExceptionMapper;
import com.deanaraujo.agenda.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		
		ContactEntity contactEntity;
		ResponseEntity<Object> response;
		HttpStatus status;
		
		try {
			contactEntity = contactService.findById(id);
			ContactDto contactDto = ContactMapper.contactEntityToContactDto(contactEntity);
			status = HttpStatus.OK;
			response = ResponseEntity.status(status).body(contactDto);
			return response;
		} catch (ContactNotFoundException e) {
			status = HttpStatus.NOT_FOUND;
			response = ResponseEntity.status(status).body(ExceptionMapper.exceptionToExceptionDto(status, e));
			return response;
		} catch (Exception e ) {
			status = HttpStatus.BAD_REQUEST;
			response = ResponseEntity.status(status).body(ExceptionMapper.exceptionToExceptionDto(status, e));
			return response;
		}
	}
}	
