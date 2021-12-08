package tinkoff.tourism.validation;

import tinkoff.tourism.model.Bar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class BarValidator implements ConstraintValidator<BarConstraint, Bar> {

    @Override
    public boolean isValid(Bar bar, ConstraintValidatorContext constraintValidatorContext) {
        return bar != null && bar.getForAdults() != null;
    }
}
