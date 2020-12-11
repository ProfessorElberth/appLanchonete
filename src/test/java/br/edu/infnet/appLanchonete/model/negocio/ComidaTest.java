package br.edu.infnet.appLanchonete.model.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.appLanchonete.model.exception.ComplementoInvalidoException;

@SpringBootTest
public class ComidaTest {

	@Test
	void testaInstanciaToString() throws ComplementoInvalidoException {
		Comida comida = new Comida("pastel", 10, Boolean.FALSE);
		comida.setDoce(Boolean.TRUE);
		comida.setComplemento("Com molho especial");
		
		assertTrue("pastel;10.0;false;true;Com molho especial".equals(comida.toString()));
	}
	
	@Test
	void testaCalculoValor() throws ComplementoInvalidoException {
		Comida comida = new Comida("pastel", 10, Boolean.FALSE);
		comida.setDoce(Boolean.TRUE);
		comida.setComplemento("Com molho especial");
		
		assertEquals(comida.calcularValorVenda(), 13);
	}
	
	@Test
	void testaComplementoInvalido() {
		try {
			Comida comida = new Comida("pastel", 10, Boolean.FALSE);
			comida.setDoce(Boolean.TRUE);
			comida.setComplemento(null);
		} catch (ComplementoInvalidoException e) {
			assertEquals("Complemento inválido.", e.getMessage());
		}
	}

	@Test
	void testaObterValorPorProduto() throws ComplementoInvalidoException {
		Comida comida = new Comida("pastel", 10, Boolean.FALSE);
		comida.setDoce(Boolean.TRUE);
		comida.setComplemento("apimentado");
		
		String result = "pastel;13.0\r";
		
		assertEquals(comida.obterValorPorProduto(), result);
	}
}