package mz.com.library.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "O Campo Autor é requerido")
	@Length(min = 3, max = 100, message = "O campo Autor deve ter entre 3 a 100 caracteres")
	private String autor;

	@NotEmpty(message = "O Campo Descrição é requerido")
	@Length(min = 3, max = 50000, message = "O campo Descrição deve ter entre 3 a 50000 caracteres")
	private String descricao;

	@NotEmpty(message = "O Campo Título é requerido")
		@Length(min = 3, max = 100, message = "O campo Título deve ter entre 3 a 100 caracteres")
	private String titulo;

	@NotEmpty(message = "O Campo Editora é requerido")
	@Length(min = 3, max = 100, message = "O campo Editora deve ter entre 3 a 100 caracteres")
	private String editora;

	@JsonIgnore // Evita a Serialização da classe
	@ManyToOne()
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Integer id, String autor, String descricao, String titulo, String editora, Categoria categoria) {
		super();
		this.id = id;
		this.autor = autor;
		this.descricao = descricao;
		this.titulo = titulo;
		this.editora = editora;
		this.categoria = categoria;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
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
