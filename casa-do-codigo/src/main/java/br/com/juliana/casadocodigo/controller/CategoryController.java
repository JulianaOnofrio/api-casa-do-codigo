package br.com.juliana.casadocodigo.controller;

import br.com.juliana.casadocodigo.dto.CategoryDTO;
import br.com.juliana.casadocodigo.exception.NotFoundException;
import br.com.juliana.casadocodigo.repository.CategoryRepository;
import br.com.juliana.casadocodigo.request.NewCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDTO> save(@RequestBody @Valid NewCategoryRequest req, UriComponentsBuilder uriBuilder) {
        var category = categoryRepository.save(req.toModel());
        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryDTO(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> find(@PathVariable Long id) {
        var category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity.ok(new CategoryDTO(category));
    }
}

