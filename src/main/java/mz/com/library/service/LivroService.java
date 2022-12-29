package mz.com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.com.library.domain.Livro;
import mz.com.library.repositories.LivroRepository;
import mz.com.library.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto/Livro náo encontrado. Id: " + id + " do tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer categoria_id) {
		categoriaService.findById(categoria_id);
		return livroRepository.findAllByCategoria(categoria_id);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj,obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setAutor(obj.getAutor());
		newObj.setCategoria(obj.getCategoria());
		newObj.setEditora(obj.getEditora());
		newObj.setLocalEd(obj.getLocalEd());
		newObj.setTitulo(obj.getTitulo());
		
	}
}
