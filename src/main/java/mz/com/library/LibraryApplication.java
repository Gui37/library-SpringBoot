package mz.com.library;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mz.com.library.domain.Categoria;
import mz.com.library.domain.Livro;
import mz.com.library.repositories.CategoriaRepository;
import mz.com.library.repositories.LivroRepository;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Aventura" , "Livros de Aventura");
		
		Livro l1 = new Livro(null, "Dante", "Dante's Inferno", "Roma", "Roman", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

	
}
