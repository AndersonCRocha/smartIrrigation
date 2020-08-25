package br.com.smartIrrigation.util;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeansSettings {

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper()
				.setDateFormat(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"));
	}
	
}
