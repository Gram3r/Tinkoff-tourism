package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.Bar;
import tinkoff.tourism.model.Cafe;
import tinkoff.tourism.model.Street;
import tinkoff.tourism.service.BarService;
import tinkoff.tourism.service.CafeService;
import tinkoff.tourism.service.StreetService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/street")
public class StreetController extends AbstractController<Street, StreetService> {
    public StreetController(StreetService service) {
        super(service);
    }
}
