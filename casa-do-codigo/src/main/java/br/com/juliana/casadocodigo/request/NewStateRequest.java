package br.com.juliana.casadocodigo.request;

import br.com.juliana.casadocodigo.model.Country;
import br.com.juliana.casadocodigo.model.State;
import br.com.juliana.casadocodigo.validation.annotation.Exists;
import br.com.juliana.casadocodigo.validation.annotation.FieldAlias;
import br.com.juliana.casadocodigo.validation.annotation.UniqueValues;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueValues(modelClass = State.class, fields = {"name", "countryId"})
public class NewStateRequest {
    @NotBlank
    private String name;

    @NotNull
    @Exists(field = "id", modelClass = Country.class)
    @FieldAlias("country.id")
    private Integer countryId;

    public NewStateRequest(String name, Integer countryId) {
        this.name = name;
        this.countryId = countryId;
    }

}