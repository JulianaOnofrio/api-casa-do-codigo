package br.com.juliana.casadocodigo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(unique = true)
    private String email;

    @Lob
    @Column(name = "descricao", length = 400)
    private String description;

    @Column(name = "dataCriacao")
    private LocalDate createdAt = LocalDate.now();

    @Deprecated
    public Author() {

    }

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
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