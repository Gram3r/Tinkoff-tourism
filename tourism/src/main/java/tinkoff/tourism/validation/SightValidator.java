package tinkoff.tourism.validation;

import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Sight;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class SightValidator implements ConstraintValidator<SightConstraint, Sight> {

    private final Pattern validHours = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]-([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
    private  final Pattern validURL = Pattern.compile("^(https?|ftp)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    @Override
    public boolean isValid(Sight sight, ConstraintValidatorContext constraintValidatorContext) {
        return sight != null &&
                sight.getName() != null && !sight.getName().isBlank() &&
                sight.getXCoordinate() != null && !sight.getXCoordinate().isInfinite() && !sight.getXCoordinate().isNaN() &&
                sight.getYCoordinate() != null &&  !sight.getYCoordinate().isInfinite() && !sight.getYCoordinate().isNaN() &&
                sight.getDescription() != null && !sight.getDescription().isBlank() &&
                sight.getSiteLink() != null && validURL.matcher(sight.getSiteLink()).matches() &&
                sight.getOpenHours() != null && validHours.matcher(sight.getOpenHours()).matches() &&
                sight.getOpenHours().substring(0, 5).compareTo(sight.getOpenHours().substring(6, 11)) < 0 &&
                sight.getPrice() >= 0;
    }
}
