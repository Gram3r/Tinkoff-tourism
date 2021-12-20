package tinkoff.tourism.validation;

import tinkoff.tourism.controller.dto.RouteRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;


public class RouteRequestValidator implements ConstraintValidator<RouteRequestConstraint, RouteRequest> {

    private final Pattern validHours = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");

    @Override
    public boolean isValid(RouteRequest route, ConstraintValidatorContext constraintValidatorContext) {

        return route != null &&
                route.getCategories() != null && route.getCategories().stream().allMatch(Objects::nonNull) &&
                (route.getStartTime() == null || validHours.matcher(route.getStartTime()).matches()) &&
                (route.getEndTime() == null || validHours.matcher(route.getEndTime()).matches());
    }
}
