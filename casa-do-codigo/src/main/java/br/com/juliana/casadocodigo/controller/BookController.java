package br.com.juliana.casadocodigo.controller;

import br.com.juliana.casadocodigo.dto.BookDTO;
import br.com.juliana.casadocodigo.dto.BookDetailDTO;
import br.com.juliana.casadocodigo.exception.NotFoundException;
import br.com.juliana.casadocodigo.repository.AuthorRepository;
import br.com.juliana.casadocodigo.repository.BookRepository;
import br.com.juliana.casadocodigo.repository.CategoryRepository;
import br.com.juliana.casadocodigo.request.NewBookRequest;
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
    @RequestMapping("/books")
    public class BookController {

        @Autowired
        private BookRepository bookRepository;

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private AuthorRepository authorRepository;

        @PostMapping
        @Transactional
        public ResponseEntity<BookDetailDTO> save(@RequestBody @Valid NewBookRequest req, UriComponentsBuilder uriBuilder) {
            var book = bookRepository.save(req.toModel(authorRepository, categoryRepository));
            URI uri = uriBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri();
            return ResponseEntity.created(uri).body(new BookDetailDTO(book));
        }

        @GetMapping("/{id}")
        public ResponseEntity<BookDTO> find(@PathVariable Long id) {
            var book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
            return ResponseEntity.ok(new BookDTO(book));
        }

        @GetMapping
        public Page<BookDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
            return bookRepository.findAll(pagination).map(BookDTO::new);
        }

    }

