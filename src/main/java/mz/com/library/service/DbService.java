package mz.com.library.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.library.domain.Categoria;
import mz.com.library.domain.Livro;
import mz.com.library.repositories.CategoriaRepository;
import mz.com.library.repositories.LivroRepository;

@Service
public class DbService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Aventura", "Livros de Aventura");
		Categoria cat2 = new Categoria(null, "Acção", "Livros de Acção");
		Categoria cat3 = new Categoria(null, "Drama", "Livros de Drama");

		Livro l1 = new Livro(null, "Dante", "Dante's Inferno", "Roma", "Roman", cat1);
		Livro l2 = new Livro(null, "Vergil", "V's Downfall", "Castel", "Capcom", cat2);
		Livro l3 = new Livro(null, "Dante", "Devil May Cry", "Constatinopla", "Roman", cat1);
		Livro l4 = new Livro(null, "Jak", "Dark Eco", "Roma", "Naughty Dog", cat3);
		Livro l5 = new Livro(null, "Nero", "Devil Trigger", "Roma", "Capcom", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l3));
		cat2.getLivros().addAll(Arrays.asList(l2, l5));
		cat3.getLivros().addAll(Arrays.asList(l4));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
