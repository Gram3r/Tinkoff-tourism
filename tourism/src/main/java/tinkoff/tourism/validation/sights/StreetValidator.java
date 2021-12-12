package tinkoff.tourism.validation.sights;

import tinkoff.tourism.model.sights.Street;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class StreetValidator implements ConstraintValidator<StreetConstraint, Street> {

    @Override
    public boolean isValid(Street street, ConstraintValidatorContext constraintValidatorContext) {
        return street != null &&
                street.getHistory() != null && !street.getHistory().isBlank();
    }
}
