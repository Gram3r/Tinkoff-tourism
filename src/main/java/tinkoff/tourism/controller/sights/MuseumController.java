package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Museum;
import tinkoff.tourism.service.sights.MuseumService;

@RestController
@RequestMapping("/museum")
public class MuseumController extends AbstractPlaceController<Museum, MuseumService> {
    public MuseumController(MuseumService service) {
        super(service);
    }
}
