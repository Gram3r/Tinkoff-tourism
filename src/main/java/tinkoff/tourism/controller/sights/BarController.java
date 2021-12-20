package tinkoff.tourism.controller.sights;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.sights.Bar;
import tinkoff.tourism.service.sights.BarService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/bar")
public class BarController extends AbstractPlaceController<Bar, BarService> {
    public BarController(BarService service) {
        super(service);
    }

    @GetMapping(value = "for-adults", produces = APPLICATION_JSON_VALUE)
    public List<Bar> getBarsByCocktailsForAdults(@RequestParam("forAdults") Boolean forAdults) {
        return service.findByCocktailsForAdults(forAdults);
    }
}
