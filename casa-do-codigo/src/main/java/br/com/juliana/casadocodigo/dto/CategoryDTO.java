package br.com.juliana.casadocodigo.dto;


import br.com.juliana.casadocodigo.model.Category;

public class CategoryDTO {
    private Long id;

    private String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
