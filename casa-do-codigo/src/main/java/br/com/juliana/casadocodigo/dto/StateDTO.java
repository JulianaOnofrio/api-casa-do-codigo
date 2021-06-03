package br.com.juliana.casadocodigo.dto;

import br.com.juliana.casadocodigo.model.State;

public class StateDTO {
    private Long id;
    private String name;

    public StateDTO(State state) {
        this.id = state.getId();
        this.name = state.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}