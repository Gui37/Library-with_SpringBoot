package mz.com.biblioteca.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Short id;
	
	@Column(length=255, nullable=false) 
	private String autor;
    
	@Column(length=255, nullable=false, unique=true)
	private String titulo;
    
	@Column(nullable=false)
	private int isbn;
    
	@Column(length=255)
	private String localEd;
    
	@Column(length=255, nullable=false)
	private String editora;
    
	@Column
	private Byte numPag;
	
	@Column	
	private LocalDate ano;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Categoria categoria;
    
    
}
