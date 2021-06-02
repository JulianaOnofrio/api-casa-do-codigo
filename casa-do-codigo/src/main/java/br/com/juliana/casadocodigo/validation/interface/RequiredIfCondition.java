package br.com.juliana.casadocodigo.validation.

public interface RequiredIfCondition <T> {
    Boolean isRequired(EntityManager manager, T value);
}