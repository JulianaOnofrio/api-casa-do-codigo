package br.com.juliana.casadocodigo.repository;


import br.com.juliana.casadocodigo.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
