package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Sight;
import tinkoff.tourism.service.SightService;

@RestController
@RequestMapping("/sight")
public class SightController extends AbstractController<Sight, SightService> {
    public SightController(SightService service) {
        super(service);
    }
}
