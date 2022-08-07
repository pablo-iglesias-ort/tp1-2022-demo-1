package com.main;

public class Estudiante {
	
	private String nombre;
	private int edad;
	
	public Estudiante(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	@Override
	public String toString() {
		return "nombre: %s - edad: %d".formatted(this.nombre, this.edad); 
	}
	
}
