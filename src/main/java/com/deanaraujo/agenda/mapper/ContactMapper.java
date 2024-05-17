package com.deanaraujo.agenda.mapper;

import com.deanaraujo.agenda.dto.ContactDto;
import com.deanaraujo.agenda.entity.ContactEntity;

public class ContactMapper {
	
	public static ContactDto contactEntityToContactDto(ContactEntity contactEntity) {
		ContactDto contactDto = new ContactDto();
		
		contactDto.setCellphone(contactEntity.getCellphone());
		contactDto.setEmail(contactEntity.getEmail());
		contactDto.setId(contactEntity.getId());
		contactDto.setName(contactEntity.getName());
		return contactDto;
	}
}
