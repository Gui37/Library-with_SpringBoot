package mz.com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mz.com.biblioteca.domain.Livro;
import mz.com.biblioteca.exception.DataNotFoundException;
import mz.com.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> listar(){
	List<Livro> livros= livroRepository.findAll();
	return livros;
	}
	
	public Livro buscarPorCodigo(Short id){
		Optional<Livro> result= livroRepository.findById(id);
		if(result.isEmpty()) {
			throw new DataNotFoundException();
		}
		Livro livro =result.get();
		return livro;
	}
	public Livro inserir(Livro livro) {
		Livro livroSalvo = livroRepository.save(livro);
		return livroSalvo;
	}
	
	
	public Optional <Livro> excluir(Short id) {
		Optional <Livro> livro = livroRepository.findById(id);
		if(livro.isEmpty()) {
			throw new DataNotFoundException();
		}
		livroRepository.delete(livro.get());
		return livro;
	}
	
	
	public Livro editar(Livro livro) {
		Livro livroEditada = livroRepository.save(livro);
		return livroEditada;
	}
}
