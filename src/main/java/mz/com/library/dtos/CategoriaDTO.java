package mz.com.library.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import mz.com.library.domain.Categoria;

public class CategoriaDTO {
	private Integer id;
	@NotEmpty(message = "O Campo Título é requerido")
	@Length(min = 3, max = 100, message = "O campo Título deve ter entre 3 a 100 caracteres")
	private String titulo;

	@NotEmpty(message = "O Campo Descrição é requerido")
	@Length(min = 3, max = 500, message = "O campo Título deve ter entre 3 a 100 caracteres")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
