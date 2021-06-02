package br.com.juliana.casadocodigo.validation.annotation;

@Constraint(validatedBy = UniqueValuesConstraint.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueValues {
    String[] fields();

    Class<?> modelClass();

    String message() default "deve ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}