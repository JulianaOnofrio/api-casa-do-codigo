package br.com.juliana.casadocodigo.request;

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