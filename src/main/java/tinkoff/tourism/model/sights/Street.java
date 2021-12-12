package tinkoff.tourism.model.sights;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tinkoff.tourism.validation.sights.StreetConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@StreetConstraint
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Street extends Sight {
    private String history;
}
