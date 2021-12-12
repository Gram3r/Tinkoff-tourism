package tinkoff.tourism.model.sights;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tinkoff.tourism.validation.sights.BarConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@BarConstraint
public class Bar extends Sight {
    private Boolean forAdults;
}
