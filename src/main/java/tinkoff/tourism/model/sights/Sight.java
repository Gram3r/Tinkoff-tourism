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

    @NonNull
    @NotBlank
    String name;

    @NonNull
    @NotBlank
    String type;

    @NonNull
    Double xCoordinate;

    @NonNull
    Double yCoordinate;

    @NonNull
    String description;

    String siteLink;

    @NonNull
    String openTime;

    @NonNull
    String closeTime;

    @PositiveOrZero
    int price;
}
