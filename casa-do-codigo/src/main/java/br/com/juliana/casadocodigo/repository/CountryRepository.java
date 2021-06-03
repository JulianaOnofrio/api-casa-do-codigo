package br.com.juliana.casadocodigo.repository;

import br.com.juliana.casadocodigo.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {
}