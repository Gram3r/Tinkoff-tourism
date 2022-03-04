package tinkoff.tourism.model.sights;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tinkoff.tourism.validation.sights.SightConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@SightConstraint

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Sight {
    Long id;
    String name;
    String type;
    Double coordinateX;
    Double coordinateY;
    String description;
    String siteLink;
    String openTime;
    String closeTime;
    @PositiveOrZero
    int price;
}
