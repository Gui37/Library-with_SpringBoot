package mz.com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.com.biblioteca.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro , Short>{

}
