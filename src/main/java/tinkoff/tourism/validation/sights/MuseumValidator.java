package tinkoff.tourism.validation.sights;

import tinkoff.tourism.model.sights.Museum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MuseumValidator implements ConstraintValidator<MuseumConstraint, Museum> {

    @Override
    public boolean isValid(Museum museum, ConstraintValidatorContext constraintValidatorContext) {
        return museum != null && museum.getDiscountForChildren() != null;
    }
}
