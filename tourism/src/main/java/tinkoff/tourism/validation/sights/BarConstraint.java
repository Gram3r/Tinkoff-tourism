package tinkoff.tourism.validation.sights;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BarValidator.class)
public @interface BarConstraint {

    String message() default "Bar fields are not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
