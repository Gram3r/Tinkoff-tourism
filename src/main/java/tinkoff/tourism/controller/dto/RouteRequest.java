package tinkoff.tourism.controller.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Data
@SuperBuilder
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteRequest {

    @NonNull
    List<String> categories;

    @NonNull
    String startTime;

    @NonNull
    String endTime;

    @NonNull
    @PositiveOrZero
    Integer budget;
}
