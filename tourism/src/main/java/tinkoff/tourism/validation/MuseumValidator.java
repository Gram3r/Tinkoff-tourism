package tinkoff.tourism.validation;

import tinkoff.tourism.model.Museum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MuseumValidator implements ConstraintValidator<MuseumConstraint, Museum> {

    @Override
    public boolean isValid(Museum museum, ConstraintValidatorContext constraintValidatorContext) {
        return museum != null && museum.getDiscountForChildren() != null;
    }
}
