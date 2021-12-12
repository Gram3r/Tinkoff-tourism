package tinkoff.tourism.validation.sights;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MuseumValidator.class)
public @interface MuseumConstraint {

    String message() default "Museum fields are not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
