package tinkoff.tourism.model.sights;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import tinkoff.tourism.validation.sights.SightConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SightConstraint
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sight {
    Long id;
    String name;
    String type;
    Double xCoordinate;
    Double yCoordinate;
    String description;
    String siteLink;
    String openTime;
    String closeTime;
    int price;
}
