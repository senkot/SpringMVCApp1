package ru.senkot.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {

    @Override
    public void initialize(ValidCountry constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext cxt) {
        return s != null && (s.length() > 0) && (s.length() < 5);
    }
}
