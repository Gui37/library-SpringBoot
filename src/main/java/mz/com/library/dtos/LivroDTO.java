package mz.com.library.dtos;

import java.io.Serializable;

import mz.com.library.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	private String autor;

	private String titulo;

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.autor = obj.getAutor();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
