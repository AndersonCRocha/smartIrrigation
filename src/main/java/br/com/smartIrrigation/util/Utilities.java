package br.com.smartIrrigation.util;

import java.time.LocalDateTime;

public class Utilities {
	
	public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	
	public static LocalDateTime now() {
		return LocalDateTime.now();
	}

}