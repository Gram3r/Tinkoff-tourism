package tinkoff.tourism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tinkoff.tourism.validation.SightConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SightConstraint
public class Sight {
    private Long id;
    private String name;
    private Double xCoordinate;
    private Double yCoordinate;
    private String description;
    private String siteLink;
    private String openHours;
    private int price;
}
