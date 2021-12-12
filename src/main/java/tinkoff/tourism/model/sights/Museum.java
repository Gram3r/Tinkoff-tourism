package tinkoff.tourism.model.sights;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tinkoff.tourism.validation.sights.MuseumConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@MuseumConstraint
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Museum extends Sight {
    private Boolean discountForChildren;
}
