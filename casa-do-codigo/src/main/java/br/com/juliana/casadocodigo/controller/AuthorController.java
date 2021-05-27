package br.com.juliana.casadocodigo.controller;

import br.com.juliana.casadocodigo.dto.AuthorDTO;
import br.com.juliana.casadocodigo.exception.NotFoundException;
import br.com.juliana.casadocodigo.repository.AuthorRepository;
import br.com.juliana.casadocodigo.request.NewAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/authors")
public class AuthorController{

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDTO> save(@RequestBody @Valid NewAuthorRequest req, UriComponentsBuilder uriBuilder) {
        var author = authorRepository.save(req.toModel());
        URI uri = uriBuilder.path("/authors/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(new AuthorDTO(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> find(@PathVariable Long id) {
        var author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity.ok(new AuthorDTO(author));
    }

}
