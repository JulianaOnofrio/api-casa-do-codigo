package br.com.juliana.casadocodigo.validation.annotation;

@Constraint(validatedBy = RequiredIfConstraint.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredIf {


    Class<? extends RequiredIfCondition> condition();

    String field();

    String message() default "obrigatório";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}