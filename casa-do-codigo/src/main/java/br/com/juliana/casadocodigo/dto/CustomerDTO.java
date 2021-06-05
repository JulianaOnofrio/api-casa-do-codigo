package br.com.juliana.casadocodigo.dto;

import br.com.juliana.casadocodigo.model.Customer;

public class CustomerDTO {
    private Long id;

    private String email;

    private String name;

    public CustomerDTO(Customer customer) {
        id = customer.getId();
        email = customer.getEmail();
        name = customer.getName();
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
}