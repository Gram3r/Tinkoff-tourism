package tinkoff.tourism.model.sights;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import tinkoff.tourism.validation.sights.SightConstraint;

import javax.validation.constraints.Min;
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
    @NotBlank
    String name;
    @NotBlank
    String type;
    Double xCoordinate;
    Double yCoordinate;
    String description;
    String siteLink;
    String openTime;
    String closeTime;
    @PositiveOrZero
    int price;
}
