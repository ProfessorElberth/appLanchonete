package br.edu.infnet.appLanchonete;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppLanchoneteApplicationTests {

	@Test
	void testeIniciarApp() {
		AppLanchoneteApplication.main(new String[] {"elberth"});
	}

}