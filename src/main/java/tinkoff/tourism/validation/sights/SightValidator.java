package tinkoff.tourism.validation.sights;

import tinkoff.tourism.model.enums.TypeEnum;
import tinkoff.tourism.model.sights.Sight;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;


public class SightValidator implements ConstraintValidator<SightConstraint, Sight> {

    private final Pattern validHours = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
    private  final Pattern validURL = Pattern.compile("^(https?|ftp)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

    @Override
    public boolean isValid(Sight sight, ConstraintValidatorContext constraintValidatorContext) {

        Set<String> enumTypes = new HashSet<>();
        for (TypeEnum typeValue : TypeEnum.values()){
            enumTypes.add(typeValue.name());
        }

        return sight != null &&
                sight.getName() != null && !sight.getName().isBlank() &&
                sight.getType() != null &&!sight.getType().isBlank() && enumTypes.contains(sight.getType().toUpperCase()) &&
                sight.getCoordinateX() != null && !sight.getCoordinateX().isInfinite() && !sight.getCoordinateX().isNaN() &&
                sight.getCoordinateY() != null && !sight.getCoordinateY().isInfinite() && !sight.getCoordinateY().isNaN() &&
                !sight.getDescription().isBlank() &&
                (sight.getSiteLink() == null || validURL.matcher(sight.getSiteLink()).matches()) &&
                sight.getOpenTime() != null && validHours.matcher(sight.getOpenTime()).matches() &&
                sight.getCloseTime() != null && validHours.matcher(sight.getCloseTime()).matches() &&
                sight.getOpenTime().compareTo(sight.getCloseTime()) < 0;
    }
}
