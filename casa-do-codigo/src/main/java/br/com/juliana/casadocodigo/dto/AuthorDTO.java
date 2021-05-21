package br.com.juliana.casadocodigo.dto;

import br.com.juliana.casadocodigo.model.Author;

public class AuthorDTO {
    private String name;
    private String email;
    private String description;

    public AuthorDTO(String name, String email, String description)
    {
        this.name = name;
        this.email = email;
        this.description = description;

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

    public Author converterAuthorDTO(AuthorDTO authorDTO) {
        return new Author(authorDTO.getName(), authorDTO.getEmail(), authorDTO.getDescription());
    }
}

