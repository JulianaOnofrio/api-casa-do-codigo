package br.com.juliana.casadocodigo.dto;

import br.com.juliana.casadocodigo.model.Author;

import java.time.LocalDate;

public class AuthorDTO {
    private Long id;

    private String name;

    private String email;

    private String description;

    private LocalDate createdAt;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
        this.createdAt = author.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
