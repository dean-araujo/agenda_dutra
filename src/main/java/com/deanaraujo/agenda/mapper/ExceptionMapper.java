package com.deanaraujo.agenda.mapper;

import org.springframework.http.HttpStatus;

import com.deanaraujo.agenda.dto.ExceptionDto;

public class ExceptionMapper {
	
	public static ExceptionDto exceptionToExceptionDto(HttpStatus status, Exception exception) {
		ExceptionDto exceptionDto = new ExceptionDto(status, exception.getMessage());
		return exceptionDto;
	}
}
