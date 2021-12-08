package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.service.BarService;

@RestController
@RequestMapping("/bar")
public class BarController extends AbstractController<Bar, BarService> {
    public BarController(BarService service) {
        super(service);
    }
}
