package br.com.juliana.casadocodigo.validation.annotation;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAlias {
    String value();
}