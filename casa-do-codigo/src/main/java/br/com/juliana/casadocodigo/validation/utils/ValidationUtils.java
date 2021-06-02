package br.com.juliana.casadocodigo.validation.utils;

public class ValidationUtils { public static String getFieldAlias(Object o, String fieldName, String defaultValue) {
    try {
        var fieldAlias = o.getClass().getDeclaredField(fieldName).getAnnotation(FieldAlias.class);
        return fieldAlias == null ? defaultValue : fieldAlias.value();
    } catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
    }
}

}
