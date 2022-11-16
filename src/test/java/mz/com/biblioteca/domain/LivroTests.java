package mz.com.biblioteca.domain;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LivroTests {
	@Test
	public void criar() {
		Livro l = new Livro(Short.valueOf("1"),
				"Guifty",
				"A queda do Murro",
				102354,
				"Maputo",
				"Singular Editores",
				Byte.valueOf("40"),
				LocalDate.of(2022, 11, 20),null);
				
		
		System.out.print(l);
	}
}
