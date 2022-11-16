package mz.com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.com.biblioteca.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{

}
