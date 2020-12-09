package br.edu.infnet.appLanchonete.model.negocio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PedidoTest {

	@Test
	void testaAssociacao() {
		Solicitante solicitante = new Solicitante("elberth", "12345678901", "elberth@elberth.com");
		
		Pedido pedido = new Pedido();
		pedido.setSolicitante(solicitante);
		
		assertTrue(solicitante.equals(pedido.getSolicitante()));
	}
	
	@Test
	void testaInternet() {
		Solicitante solicitante = new Solicitante("elberth", "12345678901", "elberth@elberth.com");
		
		Pedido pedido = new Pedido();
		pedido.setSolicitante(solicitante);

		assertTrue(pedido.isWeb());
	}
	
	@Test
	void testaBalcao() {
		Solicitante solicitante = new Solicitante("elberth", "12345678901", "elberth@elberth.com");
		
		Pedido pedido = new Pedido();
		pedido.setWeb(Boolean.FALSE);
		pedido.setSolicitante(solicitante);

		assertFalse(pedido.isWeb());
	}
	
	@Test
	void testaToString() {
		Solicitante solicitante = new Solicitante("elberth", "12345678901", "elberth@elberth.com");
		
		Pedido pedido = new Pedido();
		pedido.setWeb(Boolean.FALSE);
		pedido.setSolicitante(solicitante);

		DateTimeFormatter formatoHoje = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime hoje = LocalDateTime.now();
		
		String textoPedido = hoje.format(formatoHoje)+";false;elberth;12345678901;elberth@elberth.com";

		assertTrue(textoPedido.equals(pedido.toString()));
	}
}