package com.main;

import java.util.ArrayList;

public class Escuela {
	
	private String nombre;
	private ArrayList<Estudiante> estudiantes;
	
	public Escuela(String nombre) {
		this.nombre = nombre;
		this.estudiantes = new ArrayList<Estudiante>();
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public ArrayList<Integer> edadesDeEstudiantes() {
		ArrayList<Integer> edades = new ArrayList<Integer>();
		
		for(Estudiante estudiante : this.estudiantes) {
			edades.add(estudiante.getEdad());
		}
		
		return edades;
	}
	
	public double edadPromedio() {
		int acumulador = 0;
		
		for(Estudiante estudiante : this.estudiantes) {
			acumulador += estudiante.getEdad();
		}
		
		return (double) acumulador / this.estudiantes.size();
	}

	public void agregarEstudiante(Estudiante e) {
		this.estudiantes.add(e);
	}

	public void mostrarListado() {
		for(Estudiante estudiante : this.estudiantes) {
			System.out.println(estudiante);
		}		
	}
	
}
