package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Bar;
import tinkoff.tourism.service.sights.BarService;

@RestController
@RequestMapping("/bar")
public class BarController extends AbstractSightController<Bar, BarService> {
    public BarController(BarService service) {
        super(service);
    }
}
