package br.com.juliana.casadocodigo.validation.annotation;

@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
public @interface CpfOrCnpj {  String message() default "Precisa ser um CPF ou CNPJ válido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}