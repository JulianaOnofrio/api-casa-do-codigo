package br.com.juliana.casadocodigo.request;

import br.com.juliana.casadocodigo.model.Country;
import br.com.juliana.casadocodigo.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NewCountryRequest {
    @NotBlank
    @Unique(field = "name", modelClass = Country.class)
    private String name;

    @Deprecated
    public NewCountryRequest() {
    }

    public String getName() {
        return name;
    }

    public Country toModel() {
        return new Country(name);
    }
}