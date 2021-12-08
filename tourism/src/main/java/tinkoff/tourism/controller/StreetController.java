package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Street;
import tinkoff.tourism.service.StreetService;

@RestController
@RequestMapping("/street")
public class StreetController extends AbstractController<Street, StreetService> {
    public StreetController(StreetService service) {
        super(service);
    }
}
