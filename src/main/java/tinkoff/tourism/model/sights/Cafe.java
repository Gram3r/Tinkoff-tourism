package tinkoff.tourism.model.sights;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tinkoff.tourism.validation.sights.CafeConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@CafeConstraint
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cafe extends Sight {
    private String foodType;
}
