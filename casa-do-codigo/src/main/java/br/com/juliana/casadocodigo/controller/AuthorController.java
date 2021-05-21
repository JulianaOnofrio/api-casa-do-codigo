package br.com.juliana.casadocodigo.controller;

import br.com.juliana.casadocodigo.dto.AuthorDTO;
import br.com.juliana.casadocodigo.model.Author;
import br.com.juliana.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

        @Autowired
        private AuthorRepository authorRepository;

        @PostMapping
        public ResponseEntity<AuthorDTO> register (@RequestBody AuthorDTO authorDTO) {
            Author author = authorDTO.converterAuthorDTO(authorDTO);
            author = authorRepository.save(author);
            return ResponseEntity.ok().body(authorDTO);
        }
    }

