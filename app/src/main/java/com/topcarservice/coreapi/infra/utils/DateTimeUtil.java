package com.topcarservice.coreapi.infra.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {
	
private static final String DEFAULT_OFFSET = "-03:00"; 
	
	public static Date getByLocalDateTime(LocalDateTime dateTime) {
		Instant instant = dateTime.toInstant(ZoneOffset.of(DEFAULT_OFFSET));
		return Date.from(instant);
	}
	
	public static String formatarDataHora(LocalDateTime dataHora) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return dataHora.format(formatter);
	}

}
