package br.com.juliana.casadocodigo.request;

import br.com.juliana.casadocodigo.model.Category;
import br.com.juliana.casadocodigo.validation.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {
    @NotBlank
    @Unique(modelClass = Category.class, field = "name")
    private String name;

    @Deprecated
    public NewCategoryRequest() {
    }

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(name);
    }
}