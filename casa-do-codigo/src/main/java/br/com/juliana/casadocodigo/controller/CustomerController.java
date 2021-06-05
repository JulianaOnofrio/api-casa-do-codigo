package br.com.juliana.casadocodigo.controller;

import br.com.juliana.casadocodigo.dto.CustomerDTO;
import br.com.juliana.casadocodigo.repository.CountryRepository;
import br.com.juliana.casadocodigo.repository.CustomerRepository;
import br.com.juliana.casadocodigo.repository.StateRepository;
import br.com.juliana.casadocodigo.request.NewCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CustomerDTO> save(@RequestBody @Valid NewCustomerRequest req, UriComponentsBuilder uriBuilder) {
        var customer = customerRepository.save(req.toModel(countryRepository, stateRepository));
        URI uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDTO(customer));
    }

    @GetMapping
    public Page<CustomerDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
        return customerRepository.findAll(pagination).map(CustomerDTO::new);
    }

}