package mz.com.library.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import mz.com.library.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	@NotEmpty(message = "O Campo Autor é requerido")
	@Length(min = 3, max = 100, message = "O campo Autor deve ter entre 3 a 100 caracteres")
	private String autor;

	@NotEmpty(message = "O Campo Título é requerido")
	@Length(min = 3, max = 100, message = "O campo Título deve ter entre 3 a 100 caracteres")
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
