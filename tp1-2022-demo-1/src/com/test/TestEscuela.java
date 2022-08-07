package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.main.Escuela;
import com.main.Estudiante;

public class TestEscuela {
	
	private static final String NOMBRE_POR_DEFECTO = "test";
	private static final int CANTIDAD_POR_DEFECTO = 5;
	private static final String SALTO_LINEA = "\n";
	
	private ArrayList<Estudiante> estudiantes;
	
	public TestEscuela() {
		estudiantes = new ArrayList<>();
		estudiantes.add(new Estudiante("Summer", 18));
		estudiantes.add(new Estudiante("Rick", 53));
		estudiantes.add(new Estudiante("Morty", 14));
		estudiantes.add(new Estudiante("Beth", 35));
		estudiantes.add(new Estudiante("Jerry", 36));
	}
	
	@Test
	public void crearEscuelaConNombreAlmacenaElNombre() {
		// When
		String nombreEscuela = "Escuela Técnica Nº 36";
		
		// Then
		Escuela escuela = this.construirEscuelaSinAlumnos(nombreEscuela);
		
		// Assert
		assertEquals(nombreEscuela, escuela.getNombre());
	}
	
	@Test
	public void escuelaSinEstudiantesNoTieneListaDeEdades() {
		// When
		
		// Then
		Escuela escuela = construirEscuelaSinAlumnos();
		ArrayList<Integer> listaDeEdades = escuela.edadesDeEstudiantes(); 
		
		// Assert
		assertEquals(0, listaDeEdades.size());
	}
	
	@Test
	public void escuelaConEstudiantesDevuelveListaDeEdades() {
		// When
		int cantidadDeAlumnos = 3;
		
		// Then
		Escuela escuela = construirEscuelaConAlumnos(cantidadDeAlumnos);
		ArrayList<Estudiante> estudiantes = generarEstudiantes(cantidadDeAlumnos);
		ArrayList<Integer> listaDeEdades = escuela.edadesDeEstudiantes(); 
		
		// Assert
		assertEquals(cantidadDeAlumnos, listaDeEdades.size());
		for(Estudiante p : estudiantes) {
			assertTrue(listaDeEdades.contains(p.getEdad()));
		}
	}
		
	@Test
	public void escuelaRetornaElPromedioDeEdad() {
		// When
		double promedioEsperado = (double) (18 + 53 + 14 + 35 + 36) / 5;
		
		// Then
		Escuela escuela = construirEscuelaConAlumnos("prueba");
		
		// Assert
		assertEquals(promedioEsperado, escuela.edadPromedio());
	}
	
	@Test
	public void escuelaMuestraElListadoDeEstudiantes() {
		// When
		PrintStream systemOutOriginal = System.out;
		StringBuilder listadoEsperado = new StringBuilder("nombre: Summer - edad: 18");		
		listadoEsperado.append(SALTO_LINEA);
		listadoEsperado.append("nombre: Rick - edad: 53");
		listadoEsperado.append(SALTO_LINEA);
				
		try {
			// Aquí cambiamos el System.out para recolectar los mensajes de salida
			ByteArrayOutputStream systemOutDePrueba = new ByteArrayOutputStream();
			System.setOut(new PrintStream(systemOutDePrueba));
			
			// Then
			Escuela escuela = construirEscuelaConAlumnos(2);
			escuela.mostrarListado();
			
			// Assert
			assertEquals(listadoEsperado.toString(), systemOutDePrueba.toString());
		}
		finally {
			// Aquí restablecemos el System.out
			System.setOut(systemOutOriginal);
		}
			
	}

	
	// Métodos privados
	private Escuela construirEscuelaSinAlumnos() {
		return construirEscuelaConAlumnos(TestEscuela.NOMBRE_POR_DEFECTO, 0);
	}
	
	private Escuela construirEscuelaSinAlumnos(String nombre) {
		return construirEscuelaConAlumnos(nombre, 0);
	}
	
	private Escuela construirEscuelaConAlumnos(int cantidadEstudiantes) {
		return construirEscuelaConAlumnos(TestEscuela.NOMBRE_POR_DEFECTO, cantidadEstudiantes);
	}
	
	private Escuela construirEscuelaConAlumnos(String nombre) {
		return construirEscuelaConAlumnos(nombre, TestEscuela.CANTIDAD_POR_DEFECTO);
	}
	
	private Escuela construirEscuelaConAlumnos(String nombre, int cantidadEstudiantes) {
		Escuela escuela = new Escuela(nombre);
		ArrayList<Estudiante> estudiantes = generarEstudiantes(cantidadEstudiantes);
		
		for(int i=0; i < estudiantes.size(); i++) {
			Estudiante e = estudiantes.get(i); 
			escuela.agregarEstudiante(e);
		}

		return escuela;
	}
	
	private ArrayList<Estudiante> generarEstudiantes(int cantidad){
		int cantidadReal = Math.min(cantidad, this.estudiantes.size());
		ArrayList<Estudiante> estudiantes = new ArrayList<>();
		
		for(int i=0; i < cantidadReal; i++)
			estudiantes.add(this.estudiantes.get(i));
		
		return estudiantes;
	}

}
