package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.main.Estudiante;

public class TestEstudiante {

	@Test
	public void representacionObjetoEstudiante() {
		// When
		String nombre = "Beth";
		int edad = 35;
		String representacionEsperada = "nombre: " + nombre + " - edad: " + edad;
		
		// Then
		Estudiante estudiante = new Estudiante(nombre, edad);
		
		// Assert
		assertEquals(representacionEsperada, estudiante.toString());
	}
}
