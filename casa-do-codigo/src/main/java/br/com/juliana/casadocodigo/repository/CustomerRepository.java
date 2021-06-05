package br.com.juliana.casadocodigo.repository;

import br.com.juliana.casadocodigo.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
