package mz.com.biblioteca.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mz.com.biblioteca.domain.Livro;

@SpringBootTest
public class LivroRepositoryTests {
	
	@Autowired
	private LivroRepository LivroRepository;
	
	@Test 
	public void inserir() {
		Livro l1 = new Livro(
				null,
				"Guifty",
				"A queda do Murro",
				102354,
				"Maputo",
				"Singular Editores",
				Byte.valueOf("40"),
				LocalDate.of(2022, 11, 20),null);
				
		Livro l2 = new Livro(
				null,
				"Dante",
				"A Divina Comedia",
				256328,
				"Roma",
				"Web Cesar",
				Byte.valueOf("90"),
				LocalDate.of(1902, 06, 30),null);
				
		LivroRepository.save(l1);
		LivroRepository.save(l2);
	}
}
