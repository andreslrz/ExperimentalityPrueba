package org.clothesstore.util;

import org.clothesstore.model.dto.Mensaje;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler {
	
	public Mensaje buildMessage(Exception e) {
		return Mensaje.builder().mensaje(e.getMessage()).build();
	}

}
