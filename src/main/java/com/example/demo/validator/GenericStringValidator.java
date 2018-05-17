package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.function.Function;

public abstract class GenericStringValidator <T extends Annotation> implements ConstraintValidator<T, String> {

    protected T annotation;

    @Override
    public void initialize(T constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return condition().apply(value);
    }

    public abstract Function<String, Boolean> condition();
}

















//https://github.com/jamesyangwang/java-bean-validation-extension
