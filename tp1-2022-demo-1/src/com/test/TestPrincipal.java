package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.main.*;
import com.constantes.*;

class TestPrincipal {

	private static final PrintStream originalOut = System.out;
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private static final String SALTO_LINEA = "\n";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.setOut(originalOut);
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMain() {
		// When
		String v1 = "valor1";
		String v2 = "valor2";
		String[] argumentos = new String[] {v1, v2};		
		
		// Then
		Principal.main(argumentos);
		
		// Assert
		String mensajes = MensajesCompartidos.MENSAJE_INICIAL + SALTO_LINEA;
		mensajes = mensajes.concat(v1 + SALTO_LINEA);
		mensajes = mensajes.concat(v2 + SALTO_LINEA);
		assertEquals(mensajes, outContent.toString());		
	}

}
