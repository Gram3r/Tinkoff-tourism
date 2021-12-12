package tinkoff.tourism.model.sights;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tinkoff.tourism.validation.sights.BarConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@BarConstraint
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bar extends Sight {
    private Boolean forAdults;
}
