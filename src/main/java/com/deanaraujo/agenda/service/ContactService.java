package com.deanaraujo.agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deanaraujo.agenda.entity.ContactEntity;
import com.deanaraujo.agenda.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public ContactEntity findById(Long id){
		
		Optional<ContactEntity> optionalContactEntity = contactRepository.findById(id);
		
		ContactEntity contactEntity;
		
		if (optionalContactEntity.isEmpty()) {
			contactEntity = new ContactEntity();
		} else {
			contactEntity = optionalContactEntity.get();
		}
		return contactEntity;
	}
}
