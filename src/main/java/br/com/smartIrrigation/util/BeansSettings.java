package br.com.smartIrrigation.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class BeansSettings {

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper()
				.registerModule(newJavaTimeModule())
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	private Module newJavaTimeModule() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Utilities.DATE_FORMAT); 
		return new JavaTimeModule()
				.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
	    		.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));
	}
	
}