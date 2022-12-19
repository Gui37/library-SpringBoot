package mz.com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.library.domain.Categoria;
import mz.com.library.repositories.CategoriaRepository;
import mz.com.library.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional <Categoria> obj = categoriaRepository.findById(id); //Evita o NullPointer error
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria/Objecto não encontrado! ID: " + id + " do Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
}
