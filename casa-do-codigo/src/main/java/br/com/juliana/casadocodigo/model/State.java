package br.com.juliana.casadocodigo.model;

import javax.persistence.*;

@Entity
@Table(name = "estados", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "pais_id"}))
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Country country;

    @Deprecated
    public State() {
    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Integer getCountryId() {
        return country.getId();
    }
}