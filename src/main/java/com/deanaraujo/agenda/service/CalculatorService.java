package com.deanaraujo.agenda.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.deanaraujo.agenda.dto.AgeDto;
import com.deanaraujo.agenda.exception.CalculatorConectionException;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CalculatorService {

	public AgeDto ageCalculator(Date birthDate) throws CalculatorConectionException {
	
		DateFormat fomatter = new SimpleDateFormat("dd-MM-yyyy");
		String strBirthDate = fomatter.format(birthDate);
		
		String baseUrl = "http://localhost:8080/calculator";
		String requestUrl = baseUrl + "/" + strBirthDate;
		
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder().url(requestUrl).build();
		
		try {
			Response response = client.newCall(request).execute();
			
			String jsonResponse = response.body().string();
			
			Gson gson = new Gson();
			
			AgeDto ageDto = gson.fromJson(jsonResponse, AgeDto.class);
			
			return ageDto;
			
		} catch (IOException e) {
			throw new CalculatorConectionException("Não foi possível conectar no microsserviço calculator");
		}
	}
}
