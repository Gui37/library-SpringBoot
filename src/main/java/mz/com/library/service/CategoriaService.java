package mz.com.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.library.domain.Categoria;
import mz.com.library.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional <Categoria> obj = categoriaRepository.findById(id); //Evita o NullPointer error
		return obj.orElse(null);
	}
}
