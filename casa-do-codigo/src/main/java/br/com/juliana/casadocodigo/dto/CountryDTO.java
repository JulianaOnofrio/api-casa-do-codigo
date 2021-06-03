package br.com.juliana.casadocodigo.dto;

import br.com.juliana.casadocodigo.model.Country;

public class CountryDTO {
    private Integer id;

    private String name;

    public CountryDTO(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}