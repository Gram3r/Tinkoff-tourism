package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Street;
import tinkoff.tourism.service.sights.StreetService;

@RestController
@RequestMapping("/street")
public class StreetController extends AbstractSightController<Street, StreetService> {
    public StreetController(StreetService service) {
        super(service);
    }
}
