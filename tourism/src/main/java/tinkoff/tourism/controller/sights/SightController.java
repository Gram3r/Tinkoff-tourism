package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Sight;
import tinkoff.tourism.service.sights.SightService;

@RestController
@RequestMapping("/sight")
public class SightController extends AbstractSightController<Sight, SightService> {
    public SightController(SightService service) {
        super(service);
    }
}
