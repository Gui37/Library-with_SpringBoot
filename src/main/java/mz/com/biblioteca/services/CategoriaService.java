package mz.com.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.biblioteca.domain.Categoria;
import mz.com.biblioteca.exception.DataNotFoundException;
import mz.com.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorCodigo(Short id){
		Optional<Categoria> result= categoriaRepository.findById(id);
		if(result.isEmpty()) {
			throw new DataNotFoundException();
		}
		Categoria categoria =result.get();
		return categoria;
	}
	
	public List<Categoria> listar(){
	List<Categoria> categorias= categoriaRepository.findAll();
	return categorias;
	}
	
	public Categoria inserir( Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva; //retorno de um objecto inseriddo
	}
	
	
	
	public Optional<Categoria> excluir(Short id){
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isEmpty()) {
			throw new DataNotFoundException();
		}
		categoriaRepository.delete(categoria.get());
		return categoria;
	}
	
	public Categoria editar(Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria);
		return categoriaEditada;
	}

} 
