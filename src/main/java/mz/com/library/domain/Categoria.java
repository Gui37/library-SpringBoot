package mz.com.library.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categoria {
	private int id;
	
	private String titulo;
	
	private String descricao;
	
	private List<Livro> livros = new ArrayList<>();

	public Categoria() {
		super();
	}

	public Categoria(int id, String titulo, String descricao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
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
		Categoria other = (Categoria) obj;
		return id == other.id;
	}
	
	
	
	
	
	
}
