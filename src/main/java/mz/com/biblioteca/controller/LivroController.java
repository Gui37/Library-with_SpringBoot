package mz.com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mz.com.biblioteca.domain.Livro;
import mz.com.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("livros")
public class LivroController {
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> listar(){
	List<Livro> livros= livroRepository.findAll();
	return livros;
	}
}
