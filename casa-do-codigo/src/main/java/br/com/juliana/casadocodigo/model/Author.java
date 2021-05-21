package br.com.juliana.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String description;
    private Instant dateRegister;

    public Author(String name,
                 String email,
                 String description)
    {
        this.name = name;
        this.email = email;
        this.description = description;
        this.dateRegister = Instant.now();
    }

}

