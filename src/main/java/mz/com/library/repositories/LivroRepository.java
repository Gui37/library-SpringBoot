package mz.com.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.com.library.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
