package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.service.CafeService;

@RestController
@RequestMapping("/cafe")
public class CafeController extends AbstractController<Cafe, CafeService> {
    public CafeController(CafeService service) {
        super(service);
    }
}
