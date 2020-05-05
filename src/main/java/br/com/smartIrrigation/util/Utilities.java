package br.com.smartIrrigation.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Utilities {
	
	public static Timestamp now() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		return Timestamp.valueOf(now);
	}

}
