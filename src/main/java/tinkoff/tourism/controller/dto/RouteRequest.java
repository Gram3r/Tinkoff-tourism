package tinkoff.tourism.controller.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteRequest {
    List<String> categories;
    String startTime;
    String endTime;
    Integer budget;
}
