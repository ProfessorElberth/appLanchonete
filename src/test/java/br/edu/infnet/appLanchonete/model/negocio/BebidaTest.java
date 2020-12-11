package br.edu.infnet.appLanchonete.model.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.appLanchonete.model.exception.MedidaInvalidaException;

@SpringBootTest
public class BebidaTest {

	@Test
	void testaInstanciaToString() throws MedidaInvalidaException {
		Bebida bebida = new Bebida("suco", 5, Boolean.TRUE);
		bebida.setMarca("Da casa");
		bebida.setMedida(200);
		
		assertTrue("suco;5.0;true;200.0;Da casa".equals(bebida.toString()));		
	}
	
	@Test
	void testaCalculoValor() throws MedidaInvalidaException {
		Bebida bebida = new Bebida("suco", 5, Boolean.TRUE);
		bebida.setMarca("Da casa");
		bebida.setMedida(200);
		
		assertEquals(bebida.calcularValorVenda(), 11);
	}
	
	@Test
	void testaMedidaInvalida() {
		try {
			Bebida bebida = new Bebida("suco", 5, Boolean.TRUE);
			bebida.setMarca("Da casa");
			bebida.setMedida(-100);
		} catch (MedidaInvalidaException e) {
			assertEquals("Medida inválida.", e.getMessage());
		}
	}
	
	@Test
	void testaObterValorPorProduto() throws MedidaInvalidaException {
		Bebida bebida = new Bebida("suco", 5, Boolean.TRUE);
		bebida.setMarca("Da casa");
		bebida.setMedida(200);
		
		String result = "suco;11.0\r";
		
		assertEquals(bebida.obterValorPorProduto(), result);
	}
}