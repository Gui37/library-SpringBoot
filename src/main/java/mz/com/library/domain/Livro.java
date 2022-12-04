package mz.com.library.domain;

import java.time.LocalDate;
import java.util.Objects;


public class Livro {

	private	int id;
	 
	private String autor;
    
	
	private String titulo;
    
	
	private String localEd;
    
	
	private String editora;
    
	
	private Byte numPag;
		
	private LocalDate ano;

	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(int id, String autor, String titulo, String localEd, String editora, Byte numPag, LocalDate ano,
			Categoria categoria) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.localEd = localEd;
		this.editora = editora;
		this.numPag = numPag;
		this.ano = ano;
		this.categoria = categoria;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocalEd() {
		return localEd;
	}

	public void setLocalEd(String localEd) {
		this.localEd = localEd;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Byte getNumPag() {
		return numPag;
	}

	public void setNumPag(Byte numPag) {
		this.numPag = numPag;
	}

	public LocalDate getAno() {
		return ano;
	}

	public void setAno(LocalDate ano) {
		this.ano = ano;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return id == other.id;
	}
	
	
}
