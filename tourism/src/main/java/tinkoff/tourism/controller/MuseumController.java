package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Museum;
import tinkoff.tourism.service.MuseumService;

@RestController
@RequestMapping("/museum")
public class MuseumController extends AbstractController<Museum, MuseumService> {
    public MuseumController(MuseumService service) {
        super(service);
    }
}
