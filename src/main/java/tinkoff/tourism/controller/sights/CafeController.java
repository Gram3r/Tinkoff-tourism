package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Cafe;
import tinkoff.tourism.service.sights.CafeService;

@RestController
@RequestMapping("/cafe")
public class CafeController extends AbstractSightController<Cafe, CafeService> {
    public CafeController(CafeService service) {
        super(service);
    }
}
