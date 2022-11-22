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

import mz.com.biblioteca.domain.Categoria;
import mz.com.biblioteca.exception.DataNotFoundException;
import mz.com.biblioteca.services.CategoriaService;

@RestController 
@RequestMapping("categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	//Metodos CRUD usando anotacoes
	@GetMapping
	public List<Categoria> listar(){
	List<Categoria> categorias= categoriaService.listar();
	return categorias;
	}
	
	@GetMapping("/{id}")
	public Categoria buscarPorCodigp(@PathVariable Short id){
		try {
		Categoria categoria = categoriaService.buscarPorCodigo(id);
		return categoria;
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", e);
		}
	}
	
	@PostMapping
	public Categoria inserir(@RequestBody  Categoria categoria) {
		Categoria categoriaSalva = categoriaService.inserir(categoria);
		return categoriaSalva; //retorno de um objecto inseriddo
	}
	
	@DeleteMapping("/{id}")
	public Optional<Categoria> excluir(@PathVariable Short id){
		Optional<Categoria> categoria = categoriaService.excluir(id);
		return categoria;
	}
	
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaService.editar(categoria);
		return categoriaEditada;
	}
}
