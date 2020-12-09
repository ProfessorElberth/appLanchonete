package br.edu.infnet.appLanchonete.model.negocio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BebidaTest {

	@Test
	void testaInstanciaToString() {
		Bebida bebida = new Bebida("suco", 5, Boolean.TRUE);
		bebida.setMarca("Da casa");
		bebida.setMedida(200);
		
		assertTrue("suco;5.0;true;200.0;Da casa".equals(bebida.toString()));
		
	}
	
	@Test
	void testaCalculoValor() {
		Bebida bebida = new Bebida("suco", 5, Boolean.TRUE);
		bebida.setMarca("Da casa");
		bebida.setMedida(200);
		
		assertTrue(bebida.calcularValorVenda() == 11);
	}
}
