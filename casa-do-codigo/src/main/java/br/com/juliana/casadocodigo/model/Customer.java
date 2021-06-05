package br.com.juliana.casadocodigo.model;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(name = "nome")
    private String name;

    @Column(name = "sobrenome")
    private String lastName;

    @Column(name = "documento", unique = true)
    private String document;

    @Column(name = "endereco")
    private String address;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "cidade")
    private String city;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = true)
    private State state;

    @Column(name = "telefone")
    private String phone;

    private String cep;

    @Deprecated
    public Customer() {
    }

    public Customer(String email, String name, String lastName, String document, String address, String complement, String city, Country country, State state, String phone, String cep) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Country getPais() {
        return country;
    }

    public State getEstado() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}