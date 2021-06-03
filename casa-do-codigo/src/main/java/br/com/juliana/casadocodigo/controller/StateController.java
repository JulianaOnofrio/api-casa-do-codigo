package br.com.juliana.casadocodigo.controller;

import br.com.juliana.casadocodigo.dto.StateDTO;
import br.com.juliana.casadocodigo.repository.CountryRepository;
import br.com.juliana.casadocodigo.repository.StateRepository;
import br.com.juliana.casadocodigo.request.NewStateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<StateDTO> save(@RequestBody @Valid NewStateRequest req, UriComponentsBuilder uriBuilder) {
        var state = stateRepository.save(req.toModel(countryRepository));
        URI uri = uriBuilder.path("/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateDTO(state));
    }

    @GetMapping
    public Page<StateDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
        return stateRepository.findAll(pagination).map(StateDTO::new);
    }
}