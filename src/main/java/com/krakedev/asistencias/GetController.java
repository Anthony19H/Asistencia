package com.krakedev.asistencias;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

	@GetMapping("/prueba")
	public String obtener() {
		return "Este es el metodo get que mostrara lo que buscamos o consulatamos";
	}
}
