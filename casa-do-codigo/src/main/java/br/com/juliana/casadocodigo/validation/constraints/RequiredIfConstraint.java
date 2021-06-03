package br.com.juliana.casadocodigo.validation.constraints;

import br.com.juliana.casadocodigo.validation.annotation.RequiredIf;
import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class RequiredIfConstraint implements ConstraintValidator<RequiredIf, Object> {
    @PersistenceContext
    private EntityManager manager;

    private RequiredIfCondition condition;

    private String field;

    private String message;

    @Override
    public void initialize(RequiredIf constraintAnnotation) {
        try {
            condition = constraintAnnotation.condition().getDeclaredConstructor().newInstance();
            field = constraintAnnotation.field();
            message = constraintAnnotation.message();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        var bean = new BeanWrapperImpl(value);
        if (bean.getPropertyValue(field) != null) return true;
        var isValid = !condition.isRequired(manager, value);
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(field).addConstraintViolation();
        }
        return isValid;
    }
}