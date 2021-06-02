package br.com.juliana.casadocodigo.dto;

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