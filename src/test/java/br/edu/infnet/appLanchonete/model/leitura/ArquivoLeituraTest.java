package br.edu.infnet.appLanchonete.model.leitura;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArquivoLeituraTest {

	@Test
	void testaArquivoLeitura() {
		ArquivoLeitura.main(new String[] {"Migração realizada com sucesso."});
	}
}
