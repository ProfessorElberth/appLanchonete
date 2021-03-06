package br.edu.infnet.appLanchonete.model.negocio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTest {

	@Test
	void testaBebida() {
		Bebida bebida = null;
		
		bebida = new Bebida("suco", 5, Boolean.TRUE);
		
		assertNotNull(bebida);
	}
	
	@Test
	void testaComida() {
		Comida comida = null;
		
		comida = new Comida("pastel", 10, Boolean.FALSE);
		
		assertNotNull(comida);
	}
	
	@Test
	void testaSobremesa() {
		Sobremesa sobremesa = null;
		
		sobremesa = new Sobremesa("bolo", 15, Boolean.TRUE);
		
		assertNotNull(sobremesa);
	}
}