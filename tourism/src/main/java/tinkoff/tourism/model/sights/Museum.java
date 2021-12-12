package tinkoff.tourism.model.sights;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tinkoff.tourism.validation.sights.MuseumConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@MuseumConstraint
public class Museum extends Sight {
    private Boolean discountForChildren;
}
