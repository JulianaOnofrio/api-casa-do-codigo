package br.com.juliana.casadocodigo.repository;

import br.com.juliana.casadocodigo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}

