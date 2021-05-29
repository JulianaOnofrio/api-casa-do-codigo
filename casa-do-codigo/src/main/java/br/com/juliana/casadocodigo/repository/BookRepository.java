package br.com.juliana.casadocodigo.repository;

import br.com.juliana.casadocodigo.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
