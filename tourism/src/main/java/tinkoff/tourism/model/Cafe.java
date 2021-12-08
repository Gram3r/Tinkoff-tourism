package tinkoff.tourism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tinkoff.tourism.validation.CafeConstraint;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@CafeConstraint
public class Cafe extends Sight {
    private String foodType;
}
