package br.com.juliana.casadocodigo.repository;

import br.com.juliana.casadocodigo.model.State;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StateRepository extends PagingAndSortingRepository<State, Long> {
}