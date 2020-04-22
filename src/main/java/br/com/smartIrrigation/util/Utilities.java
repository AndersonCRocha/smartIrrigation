package br.com.smartIrrigation.util;

import java.sql.Timestamp;

public class Utilities {
	
	public static final long DIFFERENCE_IN_MILLISECONDS = 10800000;
	
	public static Timestamp today() {
		return new Timestamp(System.currentTimeMillis()-DIFFERENCE_IN_MILLISECONDS);
	}
}
