package mz.com.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mz.com.biblioteca.domain.Livro;
import mz.com.biblioteca.exception.DataNotFoundException;
import mz.com.biblioteca.services.LivroService;

@RestController
@RequestMapping("livros")
public class LivroController {
	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public List<Livro> listar(){
	List<Livro> livros= livroService.listar();
	return livros;
	}
	@GetMapping("/{id}")
	public Livro buscarPorCodigp(@PathVariable Short id){
		try {
		Livro livro = livroService.buscarPorCodigo(id);
		return livro;
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrada", e);
		}
	}
	@PostMapping
	public Livro inserir(@RequestBody Livro livro) {
		Livro livroSalvo = livroService.inserir(livro);
		return livroSalvo;
	}
	
	@DeleteMapping("/{id}")
	public Optional <Livro> excluir(@PathVariable Short id) {
		try {
		Optional <Livro> livro = livroService.excluir(id);
		return livro;
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado", e);
		}
	}
	
	@PutMapping
	public Livro editar(@RequestBody Livro livro) {
		Livro livroEditada = livroService.editar(livro);
		return livroEditada;
	}
	
}
