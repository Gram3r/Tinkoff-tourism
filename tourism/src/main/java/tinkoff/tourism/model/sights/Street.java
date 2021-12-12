package tinkoff.tourism.model.sights;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tinkoff.tourism.validation.sights.StreetConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@StreetConstraint
public class Street extends Sight {
    private String history;
}
