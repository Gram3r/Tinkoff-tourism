package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Bar;
import tinkoff.tourism.model.sights.Museum;
import tinkoff.tourism.service.sights.MuseumService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/museum")
public class MuseumController extends AbstractPlaceController<Museum, MuseumService> {
    public MuseumController(MuseumService service) {
        super(service);
    }

    @GetMapping(value = "discount-for-children", produces = APPLICATION_JSON_VALUE)
    public List<Museum> getMuseumsByDiscountForChildren(@RequestParam("discountForChildren") Boolean discountForChildren) {
        return service.findByDiscountForChildren(discountForChildren);
    }
}
