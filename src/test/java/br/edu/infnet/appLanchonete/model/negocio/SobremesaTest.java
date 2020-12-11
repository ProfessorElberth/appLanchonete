package br.edu.infnet.appLanchonete.model.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.appLanchonete.model.exception.ComplementoInvalidoException;
import br.edu.infnet.appLanchonete.model.exception.PorcaoInvalidaException;

@SpringBootTest
public class SobremesaTest {

	@Test
	void testaInstanciaToString() throws PorcaoInvalidaException {
		Sobremesa sobremesa = new Sobremesa("bolo", 15, Boolean.TRUE);
		sobremesa.setPorcao(3);
		sobremesa.setCalda(Boolean.FALSE);
		
		assertTrue("bolo;15.0;true;3;false".equals(sobremesa.toString()));
	}
	
	@Test
	void testaCalculoValor() throws PorcaoInvalidaException {
		Sobremesa sobremesa = new Sobremesa("bolo", 15, Boolean.TRUE);
		sobremesa.setPorcao(3);
		sobremesa.setCalda(Boolean.FALSE);
		
		assertEquals(sobremesa.calcularValorVenda(), 62);
	}
	
	@Test
	void testaPorcalInvalida() {
		try {
			Sobremesa sobremesa = new Sobremesa("bolo", 15, Boolean.TRUE);
			sobremesa.setCalda(Boolean.FALSE);
			sobremesa.setPorcao(15);
		} catch (PorcaoInvalidaException e) {
			assertEquals(e.getMessage(), "Porção inválida.");
		}
	}

	@Test
	void testaObterValorPorProduto() throws PorcaoInvalidaException {
		Sobremesa sobremesa = new Sobremesa("bolo", 15, Boolean.TRUE);
		sobremesa.setPorcao(3);
		sobremesa.setCalda(Boolean.FALSE);
		
		String result = "bolo;62.0\r";
		
		assertEquals(sobremesa.obterValorPorProduto(), result);
	}
}