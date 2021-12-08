package tinkoff.tourism.validation;

import tinkoff.tourism.model.Cafe;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CafeValidator implements ConstraintValidator<CafeConstraint, Cafe> {

    @Override
    public boolean isValid(Cafe cafe, ConstraintValidatorContext constraintValidatorContext) {
        return cafe != null &&
                cafe.getFoodType() != null && !cafe.getFoodType().isBlank();
    }
}
