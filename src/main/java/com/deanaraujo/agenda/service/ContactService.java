package com.deanaraujo.agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deanaraujo.agenda.entity.ContactEntity;
import com.deanaraujo.agenda.exception.ContactNotFoundException;
import com.deanaraujo.agenda.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public ContactEntity findById(Long id) throws Exception{
		
		Optional<ContactEntity> optionalContactEntity = contactRepository.findById(id);
		
		ContactEntity contactEntity;
		
		if (optionalContactEntity.isEmpty()) {
			throw new ContactNotFoundException("Contato não encontrado para o id " + id.toString());
		} else {
			contactEntity = optionalContactEntity.get();
		}
		return contactEntity;
	}
}
